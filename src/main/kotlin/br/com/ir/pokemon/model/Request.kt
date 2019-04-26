package br.com.ir.pokemon.model

import br.com.ir.pokemon.entities.Trainer
import java.time.LocalDate
import java.time.LocalDateTime

import java.util.Date

data class TrainerRequest(

    val id: Int? = null,
    val name:String?,
    val birthdate: LocalDate?,
    val created_at:LocalDateTime?,
    var update_at:LocalDateTime? = null,
    val nickName: String?
){

    fun toEntity(): Trainer{
        return Trainer  (id, name!!, birthdate!!, created_at!! , update_at, nickName!!)
    }

    data class Builder(
        var id: Int? = null,
        var name:String? = null,
        var birthdate: LocalDate? = null,
        var created_at:LocalDateTime? = null,
        var update_at:LocalDateTime? = null,
        var nickName: String? = null ) {
            fun id(id:Int) = apply { this.id = id }
            fun name(name: String) = apply { this.name = name }
            fun birthdate(birthdate: LocalDate) = apply { this.birthdate = birthdate }
            fun created_at(created_at: LocalDateTime) = apply { this.created_at = created_at }
            fun update_at(update_at: LocalDateTime) = apply { this.update_at = update_at }
            fun nickName(nickName: String) = apply { this.nickName = nickName }

            fun build() = TrainerRequest(id ,name, birthdate, created_at, update_at, nickName)
        }

}