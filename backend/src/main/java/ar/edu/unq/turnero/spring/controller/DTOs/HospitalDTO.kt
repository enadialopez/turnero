package ar.edu.unq.turnero.spring.controller.DTOs

import ar.edu.unq.turnero.modelo.Especialidad
import ar.edu.unq.turnero.modelo.Hospital

class HospitalDTO(
    var id: Long?,
    var nombre:String?,
    var municipio: String?,
    var direccion: String?,
    var imagen: String?,
    //var especialidades: MutableList<String>
) {

    companion object {
        fun desdeModelo(hospital: Hospital) =
            HospitalDTO(
                id = hospital.id,
                nombre = hospital.nombre,
                municipio = hospital.municipio,
                direccion = hospital.direccion,
                imagen = hospital.imagen,
                /*especialidades = hospital.especialidades
                    .map { especialidad -> EspecialidadDTO.desdeModelo(especialidad)}
                    .toCollection(HashSet()).toMutableList(),
            */)
    }

    fun aModelo(): Hospital {
        val hospital = Hospital()
        hospital.id = this.id
        hospital.nombre = this.nombre!!
        hospital.municipio = this.municipio
        hospital.direccion = this.direccion!!
        hospital.imagen = this.imagen!!
        /*hospital.especialidades = (this.especialidades
            ?.map { EspecialidadDTO  -> EspecialidadDTO.aModelo()}?.
            toCollection(mutableListOf<Especialidad>())
            ?: mutableListOf<Especialidad>())*/

        return hospital
    }
}

