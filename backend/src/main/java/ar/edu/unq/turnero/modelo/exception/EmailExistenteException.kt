package ar.edu.unq.turnero.modelo.exception

import javax.naming.directory.InvalidAttributesException

class EmailExistenteException: InvalidAttributesException() {

    override val message: String?
        get() = "El email ya se encuentra registrado."

    companion object {
        private val serialVersionUID = 1L
    }
}