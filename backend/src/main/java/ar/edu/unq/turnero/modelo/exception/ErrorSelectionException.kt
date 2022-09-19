package ar.edu.unq.turnero.modelo.exception

class ErrorSelectionException : Exception() {

    override val message: String?
        get() = "El valor pasado del selector no es correcto."

}