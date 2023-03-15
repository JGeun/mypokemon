package jgeun.study.mypokemon.network.service

import com.skydoves.sandwich.ApiResponse
import jgeun.study.mypokemon.model.Pokemon
import jgeun.study.mypokemon.model.PokemonInfo
import jgeun.study.mypokemon.model.PokemonType
import jgeun.study.mypokemon.network.model.BasePokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MyPokemonService {

    @GET("pokemon")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): ApiResponse<BasePokemonResponse<Pokemon>>

    @GET("pokemon/{name}")
    suspend fun fetchPokemonInfo(
        @Path("name") name: String
    ): ApiResponse<PokemonInfo>

    @GET("type")
    suspend fun fetchPokemonTypeList(

    ) : ApiResponse<BasePokemonResponse<List<PokemonType>>>
}