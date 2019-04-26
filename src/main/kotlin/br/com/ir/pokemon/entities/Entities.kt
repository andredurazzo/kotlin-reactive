package br.com.ir.pokemon.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate
import java.time.LocalDateTime


@Table("Trainer")
data class Trainer(
    @Id
    val id: Int? = null,
    val name:String,
    val birthdate: LocalDate,
    val created_at:LocalDateTime?,
    val updated_at: LocalDateTime?,
    val nickName: String

)

@Table("Trainer_Catcher")
data class TrainerCatcher(
    @Id
    val id:Long? = null,
    val trainerId:Trainer,
    val pokemonId:Pokemon

)

@Table("Catcher_Details")
data class CatcherDetails(
    @Id
    val id:Long? = null,
    val created_at: LocalDateTime,
    val updated_at: LocalDateTime?,
    val level_catcher:Long,
    val current_level: Long,
    val namePokemon: String,
    val catcher: TrainerCatcher

)

@Table("Pokemon")
data class Pokemon(
    @Id
    val id:Long? = null,
    val name:String,
    val evolutionBy: Pokemon,
    val hasEvolution: Boolean,
    val evolveLevel: Long,
    val types: Array<PokemonTypes>
)

@Table("Pokemon_Details")
data class PokemonDetails(
    @Id
    val pokemonId:Pokemon,
    val hitPoint:Long,
    val attack:Long,
    val defense:Long,
    val specialAttack: Long,
    val specialDefense: Long,
    val speed: Long

)

@Table("Pokemon_Types")
data class PokemonTypes(
    @Id
    var id:Long? = null,
    val name:String
)