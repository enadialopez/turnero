package ar.edu.unq.turnero.persistence

import ar.edu.unq.turnero.modelo.Hospital
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HospitalDAO : CrudRepository<Hospital, Long> {

    fun findAllByOrderByNombreAsc() : List<Hospital>

}