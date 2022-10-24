package ar.edu.unq.turnero.service.impl

import ar.edu.unq.turnero.modelo.Hospital
import ar.edu.unq.turnero.modelo.Usuario
import ar.edu.unq.turnero.modelo.exception.DniInvalidoException
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

    override fun crear(usuario: Usuario): Usuario {
        this.validarCampos(usuario)
        return usuarioDAO.save(usuario)
    }

    private fun validarCampos(usuario: Usuario) {
        if(usuario.nombreYApellido == "" || validarDNI(usuario.dni) || usuario.email == ""
            || usuario.password == "" || usuario.telefono == null) {
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
        //validar email
        return usuarioDAO.findByEmailContaining(email)
    }

    override fun recuperarPorToken(token: String) : Usuario? {
        //validar email
        return usuarioDAO.findByTokenContaining(token)
    }

    override fun recuperarTodos(): List<Usuario> {
        return usuarioDAO.findAllByOrderByNombreYApellidoAsc()
    }

    override fun clear() {
        usuarioDAO.deleteAll()
    }
}