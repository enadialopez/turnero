package ar.edu.unq.turnero.modelo.exception

class CampoVacioException : Exception() {

    override val message: String?
        get() = "No se puede crear con un campo vacío."

}