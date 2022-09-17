package ar.edu.unq.turnero.spring.controller.DTOs

import ar.edu.unq.turnero.modelo.Especialidad

class EspecialidadDTO (
    var id: Long?,
    var nombre:String?,
) {

    companion object {
        fun desdeModelo(especialidad: Especialidad) =
            EspecialidadDTO(
                id = especialidad.id,
                nombre = especialidad.nombre,
            )
    }

    fun aModelo(): Especialidad {
        val especialidad = Especialidad()
        especialidad.id = this.id
        especialidad.nombre = this.nombre!!

        return especialidad
    }
}

