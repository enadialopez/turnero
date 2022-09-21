package ar.edu.unq.turnero.service.impl

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
        this.validar(turno)
        return turnoDAO.save(turno)
    }

    private fun validar(turno : Turno) {
        if(turno.nombreYApellidoPaciente == "" || turno.fechaYHora == "" || turno.especialidad == "" ||
            turno.especialista == "" || turno.hospital == "") {
            throw StringVacioException()
        }
    }

    override fun actualizar(turno: Turno): Turno {
        return this.crear(turno)    }

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

    override fun clear() {
        turnoDAO.deleteAll()
    }

}