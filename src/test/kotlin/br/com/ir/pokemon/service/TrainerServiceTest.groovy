package br.com.ir.pokemon.service

import br.com.ir.pokemon.entities.Trainer
import br.com.ir.pokemon.model.TrainerRequest
import br.com.ir.pokemon.repository.TrainerRepository
import reactor.core.publisher.Mono
import spock.lang.Specification

class TrainerServiceTest extends Specification {

    private TrainerService service
    private TrainerRepository repositoryMock

    void setup() {
        repositoryMock = Mock(TrainerRepository)
        service = new TrainerService(repositoryMock)
    }

    void 'given new trainer should be persisted'(){
        given:
            TrainerRequest trainer = new TrainerRequest.Builder().id(1L).name("name").birthdate(new Date()).created_at(new Date()).update_at(new Date()).nickName("nnn").build()
        when:
            1 * repositoryMock.save(trainer.toEntity()) >> Mono.just(trainer.toEntity())
            Mono<Trainer> t = service.addTrainer(trainer)
        then:
            t.block().name == "name"
    }

    void 'given error when should be persisted trainer with null birthdate or nickName '(){
        given:
        TrainerRequest trainer = new TrainerRequest.Builder().id(1L).name("name").birthdate(new Date()).created_at(new Date()).update_at(new Date()).nickName("nnn").build()

        when:
            service.addTrainer(trainer) >> Exception

        then:
            Exception
    }

}
