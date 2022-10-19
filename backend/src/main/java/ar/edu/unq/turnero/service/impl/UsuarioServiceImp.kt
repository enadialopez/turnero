package ar.edu.unq.turnero.service.impl

import ar.edu.unq.turnero.modelo.Usuario
import ar.edu.unq.turnero.modelo.exception.StringVacioException
import ar.edu.unq.turnero.persistence.UsuarioDAO
import ar.edu.unq.turnero.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
open class UsuarioServiceImp(
    @Autowired
    private val usuarioDAO: UsuarioDAO): UsuarioService {

    private fun validarCampos(usuario: Usuario) {
        if(usuario.nombreYApellido == "" || usuario.dni == null || usuario.email == ""
            || usuario.contraseña == "" || usuario.telefono == null) {
            throw StringVacioException()
        }
    }

    override fun crear(usuario: Usuario): Usuario {
        this.validarCampos(usuario)
        return usuarioDAO.save(usuario)
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

    override fun recuperarTodos(): List<Usuario> {
        return usuarioDAO.findAllByOrderByNombreYApellidoAsc()
    }

    override fun clear() {
        usuarioDAO.deleteAll()
    }
}