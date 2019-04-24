package br.com.ir.pokemon.utils

import java.lang.NumberFormatException

class Utils{
    companion object{
        fun checkIsNumber(value:String) : Boolean{

            val v = value.toIntOrNull()
            return when(v){
                null ->  throw NumberFormatException("It's not a number!")
                else -> true
            }
        }
    }
}