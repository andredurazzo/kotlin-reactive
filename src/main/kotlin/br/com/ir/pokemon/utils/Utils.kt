package br.com.ir.pokemon.utils


class Utils{
    companion object{
        
        fun checkIsNumber(value:String) : Boolean{

            val v = value.toIntOrNull()
            return when(v){
                null ->  throw IllegalArgumentException("It's not a valid number!")
                else -> true
            }
        }
    }
}