package ar.edu.unq.turnero.spring.controller.DTOs

import ar.edu.unq.turnero.modelo.Especialidad
import ar.edu.unq.turnero.modelo.Turno
import ar.edu.unq.turnero.modelo.exception.EspecialidadVacioException

class MiniTurnoDTO(
    var id: Long?,
    var nombreYApellidoPaciente:String?,
    var dniPaciente: Long?,
    var telefonoPaciente: Long?,
    var emailPaciente: String?,
    var fechaYHora: String?,
    var fechaEmitido: String?,
    var especialidad: String?,
    var especialista:  String?,
) {

    companion object {

        fun desdeModelo(turno: Turno) =
            MiniTurnoDTO(
                id = turno.id,
                nombreYApellidoPaciente = turno.nombreYApellidoPaciente,
                dniPaciente = turno.dniPaciente,
                telefonoPaciente = turno.telefonoPaciente,
                emailPaciente = turno.emailPaciente,
                fechaYHora = turno.fechaYHora,
                fechaEmitido = turno.fechaEmitido,
                especialidad = turno.especialidad.toString().toLowerCase(),
                especialista = turno.especialista)
    }

    fun aModelo(): Turno {
        val turno = Turno()
        turno.id = this.id
        turno.nombreYApellidoPaciente = this.nombreYApellidoPaciente!!
        turno.dniPaciente = this.dniPaciente!!
        turno.telefonoPaciente = this.telefonoPaciente!!
        turno.emailPaciente = this.emailPaciente!!
        turno.fechaYHora = this.fechaYHora!!
        turno.fechaEmitido = this.fechaEmitido!!
        turno.especialidad = toEnum(this.especialidad)
        turno.especialista = this.especialista
        return turno
    }

    private fun toEspecialidades( especialidades: MutableList<Especialidad> ) : List<String> {
        var nuevasEspecialidades : List<String> = listOf()
        especialidades.forEach { especialidad -> nuevasEspecialidades += especialidad.toString().toLowerCase() }

        return nuevasEspecialidades
    }

    private fun toEnum(especialidad: String?): Especialidad {
        var nuevaEspecialidad: Especialidad
        when(especialidad) {
            "Pediatria" -> nuevaEspecialidad = Especialidad.PEDIATRIA
            "Oncologia" -> nuevaEspecialidad = Especialidad.ONCOLOGIA
            "Traumatologia" -> nuevaEspecialidad = Especialidad.TRAUMATOLOGIA
            "Urologia" -> nuevaEspecialidad = Especialidad.UROLOGIA
            "Oftalmologia" -> nuevaEspecialidad = Especialidad.OFTALMOLOGIA
            "Kinesiologia" -> nuevaEspecialidad = Especialidad.KINESIOLOGIA
            "Cardiologia" -> nuevaEspecialidad = Especialidad.CARDIOLOGIA
            "Nefrologia" -> nuevaEspecialidad = Especialidad.NEFROLOGIA
            "Reumatologia" -> nuevaEspecialidad = Especialidad.REUMATOLOGIA
            "Dermatologia" -> nuevaEspecialidad = Especialidad.DERMATOLOGIA
            else -> {
                throw EspecialidadVacioException()
            }
        }
        return nuevaEspecialidad
    }
}

