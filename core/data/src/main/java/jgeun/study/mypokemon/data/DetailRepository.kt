package jgeun.study.mypokemon.data

import androidx.annotation.WorkerThread
import jgeun.study.mypokemon.model.PokemonInfo
import kotlinx.coroutines.flow.Flow

interface DetailRepository {

    @WorkerThread
    fun fetchPokemonInfo(
        name: String,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<PokemonInfo>
}
