package jgeun.study.mypokemon.network.model

import jgeun.study.mypokemon.model.Pokemon

data class PokemonResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Pokemon>
)