package br.com.ir.pokemon.controller

import br.com.ir.pokemon.entities.Trainer
import br.com.ir.pokemon.model.TrainerRequest
import br.com.ir.pokemon.service.TrainerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
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
    fun addTrainer(@RequestBody request: TrainerRequest ){
        service.addTrainer(request)

    }

    @PutMapping(value = "/")
    fun updateTrainer(@RequestBody request: TrainerRequest): Mono<Trainer>{

        return service.updateTrainer(request)
    }

}
