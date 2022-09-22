package ar.edu.unq.turnero.service

import ar.edu.unq.turnero.modelo.Turno

interface TurnoService {

    fun crear(turno: Turno): Turno
    fun actualizar(turno: Turno):Turno
    fun recuperar(turnoId:Int): Turno?
    fun recuperarTodos(): List<Turno>
    fun recuperarTurnosDisponiblesPorHospitalYEspecialidad(hospital: String, especialidad: String) : List<Turno>
    fun eliminar(turnoId:Int)
    fun clear()
}