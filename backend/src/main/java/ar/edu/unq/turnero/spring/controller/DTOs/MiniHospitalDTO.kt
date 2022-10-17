package ar.edu.unq.turnero.spring.controller.DTOs

import ar.edu.unq.turnero.modelo.Hospital

class MiniHospitalDTO(
    var id: Long?,
    var nombre:String?,
    var direccion: String?,
) {

    companion object {
        fun desdeModelo(hospital: Hospital) =
            MiniHospitalDTO(
                id = hospital.id,
                nombre = hospital.nombre,
                direccion = hospital.direccion,
            )
    }

    fun aModelo(): Hospital {
        val hospital = Hospital()
        hospital.id = this.id
        hospital.nombre = this.nombre!!
        hospital.direccion = this.direccion!!
        return hospital
    }
}

