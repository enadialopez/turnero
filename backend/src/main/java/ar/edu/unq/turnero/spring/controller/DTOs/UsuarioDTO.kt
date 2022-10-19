package ar.edu.unq.turnero.spring.controller.DTOs

import ar.edu.unq.turnero.modelo.Hospital
import ar.edu.unq.turnero.modelo.Usuario

class UsuarioDTO(
    var id: Long?,
    var nombreYApellido: String?,
    var dni: Long? = null,
    var email: String? = null,
    var telefono: Long? = null) {

    companion object {
        fun desdeModelo(usuario: Usuario) =
            UsuarioDTO(
                id = usuario.id,
                nombreYApellido = usuario.nombreYApellido,
                dni = usuario.dni,
                email = usuario.email,
                telefono = usuario.telefono
            )
    }

    fun aModelo(): Usuario {
        val usuario = Usuario()
        usuario.id = this.id
        usuario.nombreYApellido = this.nombreYApellido!!
        usuario.dni = this.dni!!
        usuario.email = this.email!!
        usuario.telefono = this.telefono
        return usuario
    }

}