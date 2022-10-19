package ar.edu.unq.turnero.persistence

import ar.edu.unq.turnero.modelo.Usuario
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioDAO : CrudRepository<Usuario, Long>  {

    fun findAllByOrderByNombreYApellidoAsc(): List<Usuario>

}