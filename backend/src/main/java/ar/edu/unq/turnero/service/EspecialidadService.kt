package ar.edu.unq.turnero.service

import ar.edu.unq.turnero.modelo.Especialidad

interface EspecialidadService {
    fun crear(especialidad:Especialidad): Especialidad
    fun recuperar(especialidadId:Int): Especialidad?
    fun recuperarTodos(): List<Especialidad>
    fun clear()
}
