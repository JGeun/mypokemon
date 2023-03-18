package jgeun.study.mypokemon.data

import jgeun.study.mypokemon.database.dao.PokemonDao
import jgeun.study.mypokemon.database.entity.mapper.asDomain
import jgeun.study.mypokemon.model.Pokemon
import jgeun.study.mypokemon.network.Dispatcher
import jgeun.study.mypokemon.network.PokemonAppDispatchers
import jgeun.study.mypokemon.network.service.PokemonClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.suspendOnSuccess
import jgeun.study.mypokemon.database.entity.mapper.asEntity
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart


class MainRepositoryImpl @Inject constructor(
	private val pokemonClient: PokemonClient,
	private val pokemonDao: PokemonDao,
	@Dispatcher(PokemonAppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher
) : MainRepository {

    override fun fetchPokemonList(
        page: Int,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ) = flow {
        var pokemons = pokemonDao.getPokemonList(page).asDomain()
        if (pokemons.isEmpty()) {
            /**
             * fetches a list of [Pokemon] from the network and getting [ApiResponse] asynchrnousely
             */
            val response = pokemonClient.fetchPokemonList(page = page)
            response.suspendOnSuccess {
                pokemons = data.results
                pokemons.forEach { pokemon -> pokemon.page = page }
                pokemonDao.insertPokemonList(pokemons.asEntity())
                emit(pokemonDao.getAllPokemonList(page).asDomain())
            }.onFailure {
                onError(message())
            }
        } else {
            emit(pokemonDao.getAllPokemonList(page).asDomain())
        }
    }.onStart { onStart() }.onCompletion { onComplete() }.flowOn(ioDispatcher)

}