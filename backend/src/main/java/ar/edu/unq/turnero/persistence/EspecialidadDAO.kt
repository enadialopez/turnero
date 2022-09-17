package ar.edu.unq.turnero.persistence

import ar.edu.unq.turnero.modelo.Especialidad
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface EspecialidadDAO : CrudRepository<Especialidad, Long> {

    fun findAllByOrderByNombreAsc() : List<Especialidad>
}