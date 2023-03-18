package jgeun.study.mypokemon.data

import com.skydoves.sandwich.*
import jgeun.study.mypokemon.database.dao.PokemonInfoDao
import jgeun.study.mypokemon.database.entity.mapper.asDomain
import jgeun.study.mypokemon.database.entity.mapper.asEntity
import jgeun.study.mypokemon.model.PokemonInfo
import jgeun.study.mypokemon.network.Dispatcher
import jgeun.study.mypokemon.network.PokemonAppDispatchers
import jgeun.study.mypokemon.network.service.PokemonClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import jgeun.study.mypokemon.network.model.PokemonErrorResponse
import jgeun.study.mypokemon.network.model.mapper.ErrorResponseMapper
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion

class DetailRepositoryImpl @Inject constructor(
	private val pokemonClient: PokemonClient,
	private val pokemonInfoDao: PokemonInfoDao,
	@Dispatcher(PokemonAppDispatchers.IO) private val ioDispatchers: CoroutineDispatcher
) : DetailRepository {

    override fun fetchPokemonInfo(
        name: String,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ) = flow {
        val pokemonInfo = pokemonInfoDao.getPokemonInfo(name)
        if (pokemonInfo == null) {
            /**
             * fetches a [PokemonInfo] from the network and getting [ApiResponse] asynchronously.
             */
            val response = pokemonClient.fetchPokemonInfo(name)
            response.suspendOnSuccess {
                pokemonInfoDao.insertPokemonInfo(data.asEntity())
                emit(data)
            }

                // handles the case when the API request gets an error response
                // e.g., internal server error.
                .onError {
                    /** maps the [ApiResponse.Failure.Error] to the [PokemonErrorResponse] using the mapper. */
                    map(ErrorResponseMapper) { onError("[Code: $code]: $message") }
                }
                // handles the case when the API request gets an exception response.
                // e.g., network connection error.
                .onException { onError(message) }
        } else {
            emit(pokemonInfo.asDomain())
        }
    }.onCompletion { onComplete() }.flowOn(ioDispatchers)


}