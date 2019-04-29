package br.com.ir.pokemon.controller

import br.com.ir.pokemon.entities.PokemonTypes
import br.com.ir.pokemon.entities.Trainer
import br.com.ir.pokemon.model.PokemonRequest
import br.com.ir.pokemon.model.PokemonResponse
import br.com.ir.pokemon.model.TrainerRequest
import br.com.ir.pokemon.repository.PokemonTypesRepository
import br.com.ir.pokemon.service.PokemonService
import br.com.ir.pokemon.service.TrainerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@RestController
@RequestMapping("/api/trainer")
class TrainerController {
    @Autowired lateinit var service: TrainerService

    @GetMapping(path =  ["/"], produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun findAll() = service.findAll()


    @GetMapping("/{id}")
    fun findOne(@PathVariable id: String) =
        service.findById(id)

    @PostMapping(value = "/")
    @ResponseStatus(value = HttpStatus.CREATED)
    fun addTrainer(@RequestBody request: TrainerRequest ): Mono<Trainer>{
        return service.addTrainer(request)

    }

    @PutMapping(value = "/")
    fun updateTrainer(@RequestBody request: TrainerRequest): Mono<Trainer>{

        return service.updateTrainer(request)
    }

    @DeleteMapping(value = ["/{id}"])
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun deleteTrainer(@PathVariable id:String) = service.deleteTrainer(id)

}


@RestController
@RequestMapping("/api/pokemon/types")
class PokemonTypesController(){
    @Autowired  lateinit var repository: PokemonTypesRepository

    @GetMapping(path =  ["/"], produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun findAll():Flux<PokemonTypes> {
        return repository.findAll()
    }
}

@RestController
@RequestMapping("/api/pokemon")
class PokemonController(){
    @Autowired lateinit var service: PokemonService

    @GetMapping(path =  ["/"], produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun findAll():Flux<PokemonResponse>{

        return service.findAll()
    }

    fun save(@RequestBody request: PokemonRequest):Mono<PokemonResponse>{
        return service.addPokemon(request)
    }

}