package jgeun.study.mypokemon.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jgeun.study.mypokemon.network.Dispatcher
import jgeun.study.mypokemon.network.PokemonAppDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
internal object DispatchersModule {

    @Provides
    @Dispatcher(PokemonAppDispatchers.IO)
    fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO
}