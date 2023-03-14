package jgeun.study.mypokemon.network

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val pokemonAppDispatchers: PokemonAppDispatchers)

enum class PokemonAppDispatchers {
  IO
}
