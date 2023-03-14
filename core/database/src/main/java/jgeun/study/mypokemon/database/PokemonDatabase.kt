package jgeun.study.mypokemon.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import jgeun.study.mypokemon.database.dao.PokemonDao
import jgeun.study.mypokemon.database.dao.PokemonInfoDao
import jgeun.study.mypokemon.database.dao.PokemonTypeDao
import jgeun.study.mypokemon.database.entity.PokemonEntity
import jgeun.study.mypokemon.database.entity.PokemonInfoEntity

@Database(
    entities = [PokemonEntity::class, PokemonInfoEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(value = [TypeResponseConverter::class])
abstract class PokemonDatabase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao
    abstract fun pokemonInfoDao(): PokemonInfoDao
    abstract fun pokemonTypeDao(): PokemonTypeDao
}