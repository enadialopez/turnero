package ar.edu.unq.turnero.modelo.exception

import javax.naming.directory.InvalidAttributesException

class PasswordInvalidoException: InvalidAttributesException() {

    override val message: String?
        get() = "Debe ingresar un Password valido."

    companion object {
        private val serialVersionUID = 1L
    }
}