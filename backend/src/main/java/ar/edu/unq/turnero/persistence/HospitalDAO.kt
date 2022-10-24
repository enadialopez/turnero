package ar.edu.unq.turnero.persistence

import ar.edu.unq.turnero.modelo.Hospital
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HospitalDAO : CrudRepository<Hospital, Long> {

    fun findAllByOrderByNombreAsc() : List<Hospital>

    fun findByNombreContaining(nombre: String) : List<Hospital>

    fun findByMunicipioContaining(M: String) : List<Hospital>

    @Query( "SELECT * FROM hospital h INNER JOIN hospital_especialidades he ON h.id = he.hospital_id WHERE he.especialidad LIKE %?1%", nativeQuery= true )
    fun findByEspecialidad(especialidad: String) : List<Hospital>
}