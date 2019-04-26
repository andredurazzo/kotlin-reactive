package br.com.ir.pokemon.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND)
object NotFoundException : RuntimeException()

@ResponseStatus(value = HttpStatus.BAD_REQUEST,  reason =  "It's not a valid path")
object BadRequestException : RuntimeException()