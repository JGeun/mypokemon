package jgeun.study.mypokemon.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jgeun.study.mypokemon.network.service.MyPokemonClient
import jgeun.study.mypokemon.network.service.MyPokemonService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    const val BASE_URL = "https://pokeapi.co/api/v2/"

    @Provides
    @Singleton
    fun provideRequestHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideMyPokemonService(retrofit: Retrofit): MyPokemonService {
        return retrofit.create(MyPokemonService::class.java)
    }

    @Provides
    @Singleton
    fun providePokedexClient(pokedexService: MyPokemonService): MyPokemonClient {
        return MyPokemonClient(pokedexService)
    }
}