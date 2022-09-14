package ar.edu.unq.turnero.spring.controller.DTOs

import ar.edu.unq.turnero.modelo.Especialidad
import ar.edu.unq.turnero.modelo.Hospital

class HospitalDTO(
    var id: Long?,
    var nombre:String?,
    var zona: String?,
    var direccion: String?,
    var especialidades: MutableList<EspecialidadDTO>
) {

    companion object {
        fun desdeModelo(hospital: Hospital) =
            HospitalDTO(
                id = hospital.id,
                nombre = hospital.nombre,
                zona = hospital.zona,
                direccion = hospital.direccion,
                especialidades = hospital.especialidades
                    .map { especialidad -> EspecialidadDTO.desdeModelo(especialidad)}
                    .toCollection(HashSet()).toMutableList(),
            )
    }

    fun aModelo(): Hospital {
        val hospital = Hospital()
        hospital.id = this.id
        hospital.nombre = this.nombre!!
        hospital.zona = this.zona
        hospital.direccion = this.direccion!!
        hospital.especialidades = (this.especialidades
            ?.map { EspecialidadDTO  -> EspecialidadDTO.aModelo()}?.
            toCollection(mutableListOf<Especialidad>())
            ?: mutableListOf<Especialidad>())

        return hospital
    }
}

