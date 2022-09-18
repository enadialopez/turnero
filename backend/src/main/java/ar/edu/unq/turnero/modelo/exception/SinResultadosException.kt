package ar.edu.unq.turnero.modelo.exception

class SinResultadosException : Exception() {

    override val message: String?
        get() = "Tu búsqueda no arrojó ningún resultado! Probá con otro término de búsqueda."

}