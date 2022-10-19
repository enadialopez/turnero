package ar.edu.unq.turnero.service

import ar.edu.unq.turnero.modelo.Usuario

interface UsuarioService {
    fun crear(usuario: Usuario): Usuario
    fun actualizar(usuario: Usuario): Usuario
    fun recuperar(usuarioId: Int): Usuario?
    fun recuperarTodos(): List<Usuario>
    fun clear()

}