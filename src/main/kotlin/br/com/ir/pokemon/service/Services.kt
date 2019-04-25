package br.com.ir.pokemon.service

import br.com.ir.pokemon.entities.Trainer
import br.com.ir.pokemon.model.TrainerRequest
import br.com.ir.pokemon.repository.TrainerRepository
import br.com.ir.pokemon.utils.Utils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Service
class TrainerService( @Autowired private var repository: TrainerRepository){


    fun addTrainer(request: TrainerRequest): Mono<Trainer> {
        checkNotNull(request.birthdate)
        checkNotNull(request.nickName)
        return repository.save(request.toEntity())
    }

    fun findAll():Flux<Trainer> {
        return repository.findAll()
    }
    fun findById(id:String):Mono<Trainer> {
        Utils.checkIsNumber(id)


        return repository.findById(id.toLong())
    }

    fun updateTrainer(request: TrainerRequest): Mono<Trainer> {

        return addTrainer(request)


    }
}