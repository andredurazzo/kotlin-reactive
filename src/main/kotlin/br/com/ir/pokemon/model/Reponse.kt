package br.com.ir.pokemon.model

import br.com.ir.pokemon.entities.Pokemon
import br.com.ir.pokemon.entities.PokemonDetails

data class PokemonResponse(
    val pokemon:Pokemon?,
    val baseStatus:PokemonDetails?
){

    data class  Builder(var pokemon: Pokemon? = null, var baseStatus: PokemonDetails? = null){
        fun pokemon(pokemon: Pokemon) =apply { this.pokemon = pokemon }
        fun baseStatus(baseStatus: PokemonDetails?) = apply { this.baseStatus = baseStatus }
        fun build() = PokemonResponse(pokemon, baseStatus)
    }
}
