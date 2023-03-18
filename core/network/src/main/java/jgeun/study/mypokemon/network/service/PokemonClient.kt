package jgeun.study.mypokemon.network.service

import com.skydoves.sandwich.ApiResponse
import jgeun.study.mypokemon.model.Pokemon
import jgeun.study.mypokemon.model.PokemonInfo
import jgeun.study.mypokemon.model.PokemonType
import jgeun.study.mypokemon.network.model.BasePokemonResponse

class PokemonClient(
    private val pokemonService: PokemonService
) {

    suspend fun fetchPokemonList(
        page: Int
    ): ApiResponse<BasePokemonResponse<Pokemon>> =
        pokemonService.fetchPokemonList(
            limit = PAGING_SIZE,
            offset = page * PAGING_SIZE
        )

    suspend fun fetchPokemonInfo(
        name: String
    ) : ApiResponse<PokemonInfo> =
        pokemonService.fetchPokemonInfo(
            name = name
        )

    suspend fun fetchPokemonTypeList(

    ) : ApiResponse<BasePokemonResponse<List<PokemonType>>> =
        pokemonService.fetchPokemonTypeList()


    companion object {
        private const val PAGING_SIZE  = 20
    }
}