package ar.edu.unq.turnero.spring.controller.DTOs

import ar.edu.unq.epers.ubermen.tp.modelo.Heroe

class HeroeDTO (
    val id: Long?,
    val nombre:String?,
    val vida:Int = 1,
    val imagenUrl:String?,
    val constitucion : Int = 1,
    val fuerza : Int = 1,
    val inteligencia : Int = 1,
    val destreza : Int = 1) {

    companion object {
        fun desdeModelo(heroe: Heroe) =
            HeroeDTO
    }

    fun aModelo(): Heroe {
        val heroe = Heroe()

        return heroe
    }
}

