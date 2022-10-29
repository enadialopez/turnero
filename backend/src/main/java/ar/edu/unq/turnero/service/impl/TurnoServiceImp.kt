package ar.edu.unq.turnero.service.impl

import ar.edu.unq.turnero.modelo.Especialidad
import ar.edu.unq.turnero.modelo.Hospital
import ar.edu.unq.turnero.modelo.Turno
import ar.edu.unq.turnero.modelo.exception.StringVacioException
import ar.edu.unq.turnero.persistence.TurnoDAO
import ar.edu.unq.turnero.service.TurnoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
open class TurnoServiceImp(
    @Autowired
    private val turnoDAO: TurnoDAO
) : TurnoService {

    override fun crear(turno: Turno): Turno {
        this.validarBase(turno)
        return turnoDAO.save(turno)
    }

    private fun validarBase(turno : Turno) {
        if(turno.fechaYHora == "" || turno.especialidad == null ||
            turno.especialista == "" || turno.hospital == null) {
            throw StringVacioException()
        }
    }

    private fun validarActualizacion(turno : Turno) {
        if(turno.nombreYApellidoPaciente == "" || turno.dniPaciente == null ||
            turno.telefonoPaciente == null || turno.emailPaciente == "") {
            throw StringVacioException()
        }
    }

    override fun actualizar(turno: Turno): Turno {
        this.validarActualizacion(turno)
        turno.cambiarFechaEmitido()
        return this.crear(turno)
    }

    override fun recuperar(turnoId:Int): Turno {
        val turno = turnoDAO.findByIdOrNull(turnoId.toLong())
        if (turno == null) {
            throw RuntimeException("El id [${turnoId}] no existe.")
        }
        return turno
    }

    override fun recuperarTodos():List<Turno> {
        return turnoDAO.findAllByOrderByNombreYApellidoPacienteAsc()
    }

    override fun eliminar(turnoId:Int) {
        this.recuperar(turnoId)
        turnoDAO.deleteById(turnoId.toLong())
    }

    override fun recuperarTurnosDisponiblesPorHospitalYEspecialidad(hospital: Hospital, especialidad: Especialidad): List<Turno> {
        return turnoDAO.findByHospitalAndEspecialidadAndDniPacienteIsNull(hospital, especialidad)
    }

    override fun borrarUsuarioDeTodosSusTurnos(usuarioId: Int) {
        turnoDAO.borrarUsuarioDeTodosSusTurnos(usuarioId.toLong())
    }

    override fun clear() {
        turnoDAO.deleteAll()
    }

}