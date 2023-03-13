package jgeun.study.mypokemon.network.model

data class PokemonDetailResponse(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<TypeResponse>,
    val stats: List<Stat>
)

data class TypeResponse(
    val slot: Int,
    val type: Type
)

data class Type(
    val name: String,
    val url: String
)

data class Stat(
    val baseStat: Int,
    val effort: Int,
    val stat: StatNameUrl
)

data class StatNameUrl(
    val name: String,
    val url: String
)