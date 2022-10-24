package ar.edu.unq.turnero.modelo.exception

import javax.naming.directory.InvalidAttributesException

class DniInvalidoException: InvalidAttributesException() {

    override val message: String?
        get() = "Debe ingresar un DNI valido."

    companion object {
        private val serialVersionUID = 1L
    }
}