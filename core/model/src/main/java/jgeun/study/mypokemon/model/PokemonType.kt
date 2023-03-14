package jgeun.study.mypokemon.model

import com.squareup.moshi.Json

data class PokemonType(
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "url")
    val url: String
)