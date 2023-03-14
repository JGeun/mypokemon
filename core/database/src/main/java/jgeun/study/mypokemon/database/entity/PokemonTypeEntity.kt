package jgeun.study.mypokemon.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonTypeEntity(
    @PrimaryKey val name: String,
    val url: String
)