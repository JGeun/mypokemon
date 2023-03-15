package jgeun.study.mypokemon.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jgeun.study.mypokemon.data.DetailRepository
import jgeun.study.mypokemon.data.DetailRepositoryImpl
import jgeun.study.mypokemon.data.MainRepository
import jgeun.study.mypokemon.data.MainRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsMainRepository(
        mainRepositoryImpl: MainRepositoryImpl
    ): MainRepository

    @Binds
    fun bindsDetailRepository(
        detailRepositoryImpl: DetailRepositoryImpl
    ): DetailRepository
}