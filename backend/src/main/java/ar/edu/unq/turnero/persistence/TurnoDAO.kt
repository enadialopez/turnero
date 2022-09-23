package ar.edu.unq.turnero.persistence

import ar.edu.unq.turnero.modelo.Hospital
import ar.edu.unq.turnero.modelo.Turno
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TurnoDAO : CrudRepository<Turno, Long> {

    fun findAllByOrderByNombreYApellidoPacienteAsc() : List<Turno>

    fun findByHospitalAndEspecialidadAndDniPacienteIsNull(hospital: String, especialidad: String) : List<Turno>

}
