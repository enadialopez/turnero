package ar.edu.unq.turnero.spring.controller.DTOs

import ar.edu.unq.turnero.modelo.Usuario

class MiniUsuarioDTO(
    var id: Long?,
    var email: String?,
    var password: String?) {

    companion object {
        fun desdeModelo(usuario: Usuario) =
            MiniUsuarioDTO(
                id = usuario.id,
                email = usuario.email,
                password = usuario.password
            )
    }
}