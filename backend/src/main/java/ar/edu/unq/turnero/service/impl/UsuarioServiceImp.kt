package ar.edu.unq.turnero.service.impl

import ar.edu.unq.turnero.modelo.Turno
import ar.edu.unq.turnero.modelo.Usuario
import ar.edu.unq.turnero.modelo.exception.DniInvalidoException
import ar.edu.unq.turnero.modelo.exception.StringVacioException
import ar.edu.unq.turnero.persistence.UsuarioDAO
import ar.edu.unq.turnero.service.TurnoService
import ar.edu.unq.turnero.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
open class UsuarioServiceImp(
    @Autowired
    private val usuarioDAO: UsuarioDAO,
    private val turnoService: TurnoService): UsuarioService {

    override fun crear(usuario: Usuario): Usuario {
        this.validarCampos(usuario)
        return usuarioDAO.save(usuario)
    }

    private fun validarCampos(usuario: Usuario) {
        if(usuario.nombreYApellido == "" || validarDNI(usuario.dni) || usuario.email == ""
            || usuario.password == "") {
            throw StringVacioException()
        }
    }

    private fun validarDNI(dni: Long?) : Boolean {
        if(dni == null || dni <= 999999 || dni > 99999999 || usuarioDAO.findByDni(dni) != null) {
            throw DniInvalidoException()
        } else {
            return false
        }
    }

    override fun actualizar(usuario: Usuario): Usuario {
        return usuarioDAO.save(usuario)
    }

    override fun recuperar(usuarioId: Int): Usuario? {
        val user = usuarioDAO.findByIdOrNull(usuarioId.toLong())
        if (user == null) {
            throw RuntimeException("El id [${usuarioId}] no existe.")
        }
        return user
    }

    override fun recuperarPorEmail(email: String) : Usuario? {
        val user = usuarioDAO.findByEmailContaining(email)
        if( user == null) {
            throw RuntimeException("No existe un usuario con ese email registrado.")
        }
        return user
    }

    override fun recuperarPorToken(token: String) : Usuario? {
        val user = usuarioDAO.findByToken(token)
        if( user == null) {
            throw RuntimeException("No existe un usuario con el token asignado.")
        }
        return user
    }

    override fun recuperarTurnosDeUsuario(id: Int) : List<Turno> {
        val user = this.recuperar(id)
        return turnoService.recuperarTurnosAsignadosAUsuario(user!!.dni!!)
    }

    override fun recuperarTodos(): List<Usuario> {
        return usuarioDAO.findAllByOrderByNombreYApellidoAsc()
    }

    override fun eliminar(usuarioId: Int) {
        /*var user = recuperar(usuarioId)
        user!!.turnosAsignados.map {t -> t.desasignarAPaciente()}
        actualizar(user)*/
        //usuarioDAO.borrarUsuarioDeTodosSusTurnos(usuarioId.toLong())
        turnoService.borrarUsuarioDeTodosSusTurnos(usuarioId)
        usuarioDAO.deleteById(usuarioId.toLong())
    }

    override fun clear() {
        usuarioDAO.deleteAll()
    }
}