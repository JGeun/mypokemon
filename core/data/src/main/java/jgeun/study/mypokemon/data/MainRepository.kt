package jgeun.study.mypokemon.data

import androidx.annotation.WorkerThread
import jgeun.study.mypokemon.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    @WorkerThread
    fun fetchPokemonList(
        page: Int,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<List<Pokemon>>

}