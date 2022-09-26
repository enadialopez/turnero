package ar.edu.unq.turnero.spring.controller.DTOs

import ar.edu.unq.turnero.modelo.Hospital

class MiniHospitalDTO(
    var id: Long?,
    var nombre:String?,
) {

    companion object {
        fun desdeModelo(hospital: Hospital) =
            MiniHospitalDTO(
                id = hospital.id,
                nombre = hospital.nombre,
            )
    }

    fun aModelo(): Hospital {
        val hospital = Hospital()
        hospital.id = this.id
        hospital.nombre = this.nombre!!
        return hospital
    }
}

