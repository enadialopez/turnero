package ar.edu.unq.turnero.modelo.exception

class StringVacioException : RuntimeException() {

    override val message: String?
        get() = "El string no puede ser vacío."

    companion object {

        private val serialVersionUID = 1L
    }
}