package ar.edu.unq.turnero.modelo.exception

import javax.naming.directory.InvalidAttributesException

class EmailInvalidoException: InvalidAttributesException() {

    override val message: String?
        get() = "Debe ingresar un Email valido."

    companion object {
        private val serialVersionUID = 1L
    }
}