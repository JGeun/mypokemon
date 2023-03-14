package jgeun.study.mypokemon.network.service

import jgeun.study.mypokemon.model.Pokemon
import jgeun.study.mypokemon.model.PokemonType
import jgeun.study.mypokemon.network.model.BasePokemonResponse
import jgeun.study.mypokemon.network.model.PokemonDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MyPokemonService {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): BasePokemonResponse<Pokemon>

    @GET("pokemon/{id}")
    suspend fun getPokemon(
        @Path("id") id: Int
    ): PokemonDetailResponse

    @GET("type")
    suspend fun getPokemonType() : BasePokemonResponse<PokemonType>
}