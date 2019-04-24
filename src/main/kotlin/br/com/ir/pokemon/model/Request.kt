package br.com.ir.pokemon.model

import br.com.ir.pokemon.entities.Trainer

import java.util.Date

data class TrainerRequest(

    val id: Long? = null,
    val name:String?,
    val birthdate: Date?,
    val created_at:Date?,
    val update_at:Date? = null,
    val nickName: String?
){

    fun toEntity(): Trainer{
        return Trainer  (id, name!!, birthdate!!, created_at!! , update_at, nickName!!)
    }

    data class Builder(
        var id: Long? = null,
        var name:String? = null,
        var birthdate: Date? = null,
        var created_at:Date? = null,
        var update_at:Date? = null,
        var nickName: String? = null ) {
            fun id(id:Long) = apply { this.id = id }
            fun name(name: String) = apply { this.name = name }
            fun birthdate(birthdate: Date) = apply { this.birthdate = birthdate }
            fun created_at(created_at: Date) = apply { this.created_at = created_at }
            fun update_at(update_at: Date) = apply { this.update_at = update_at }
            fun nickName(nickName: String) = apply { this.nickName = nickName }

            fun build() = TrainerRequest(id ,name, birthdate, created_at, update_at, nickName)
        }

}