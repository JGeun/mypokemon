package jgeun.study.mypokemon.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import jgeun.study.mypokemon.database.entity.PokemonTypeEntity

@Dao
interface PokemonTypeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonType(pokemonType: PokemonTypeEntity)

    @Query("SELECT * FROM PokemonInfoEntity WHERE name = :name_")
    suspend fun getPokemonType(name_: String): PokemonTypeEntity?
}