package br.com.ir.pokemon.repository


import br.com.ir.pokemon.entities.Pokemon
import br.com.ir.pokemon.entities.PokemonTypes
import br.com.ir.pokemon.entities.Trainer
import org.springframework.data.r2dbc.repository.R2dbcRepository

import org.springframework.stereotype.Repository

@Repository
interface TrainerRepository : R2dbcRepository<Trainer, Int> {

    //fun findAllByOrderByCreated_atDesc(): Iterable<Trainer>
}
@Repository
interface PokemonRepository : R2dbcRepository<Pokemon, Long> {

    //
}
@Repository
interface PokemonTypesRepository : R2dbcRepository<PokemonTypes, Long>{
    //
}
