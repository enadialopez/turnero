package ar.edu.unq.turnero.spring.controller.DTOs

import ar.edu.unq.turnero.modelo.Usuario

class UsuarioDTO(
    var id: Long?,
    var nombreYApellido: String?,
    var dni: Long?,
    var email: String?,
    var telefono: Long?,
    var password: String?) {

    companion object {
        fun desdeModelo(usuario: Usuario) =
            UsuarioDTO(
                id = usuario.id,
                nombreYApellido = usuario.nombreYApellido,
                dni = usuario.dni,
                email = usuario.email,
                telefono = usuario.telefono,
                password = usuario.password
            )
    }

    fun aModelo(): Usuario {
        val usuario = Usuario()
        usuario.id = this.id
        usuario.nombreYApellido = this.nombreYApellido!!
        usuario.dni = this.dni!!
        usuario.email = this.email!!
        usuario.telefono = this.telefono
        usuario.password = this.password
        return usuario
    }

}