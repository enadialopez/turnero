package ar.edu.unq.turnero.modelo.exception

class TelefonoInvalidoException: Exception() {

    override val message: String?
        get() = "Debe ingresar un teléfono valido, debe contener 10 caracteres."

    companion object {
        private val serialVersionUID = 1L
    }
}