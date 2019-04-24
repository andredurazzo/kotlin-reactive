package br.com.ir.pokemon

import java.time.LocalDateTime
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField
import java.util.Locale

fun LocalDateTime.format() = this.format(brazilianDateFormatter)

private val englishDateFormatter = DateTimeFormatterBuilder()
    .appendPattern("yyyy-MM-dd")
    .appendLiteral(" ")
    .appendText(ChronoField.DAY_OF_MONTH)
    .appendLiteral(" ")
    .appendPattern("yyyy")
    .toFormatter(Locale.ENGLISH)

private val brazilianDateFormatter = DateTimeFormatterBuilder()
    .appendPattern("dd/MM/yyyy")
    .appendLiteral(" ")
    .appendText(ChronoField.DAY_OF_MONTH)
    .appendLiteral(" ")
    .appendPattern("yyyy").toFormatter(Locale("pt", "BR"))