package ar.edu.unq.turnero.persistence

import ar.edu.unq.turnero.modelo.Hospital
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HospitalDAO : CrudRepository<Hospital, Long> {

    fun findAllByOrderByNombreAsc() : List<Hospital>

    fun findByNombreContaining(nombre: String) : List<Hospital>

    fun findByZonaContaining(zona: String) : List<Hospital>

    @Query( "SELECT h FROM Hospital h INNER JOIN h.especialidades e WHERE e.nombre LIKE %?1%" )
    fun recuperarPorEspecialidad(especialidad: String) : List<Hospital>
}