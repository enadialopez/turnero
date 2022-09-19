package ar.edu.unq.turnero.modelo.exception

class CampoVacioException : Exception() {

    override val message: String?
        get() = "Este campo no puede estar vacío."

}