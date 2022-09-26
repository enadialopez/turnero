package ar.edu.unq.turnero.service

import ar.edu.unq.turnero.modelo.Especialidad
import ar.edu.unq.turnero.modelo.Hospital
import ar.edu.unq.turnero.modelo.Turno

interface TurnoService {

    fun crear(turno: Turno): Turno
    fun actualizar(turno: Turno):Turno
    fun recuperar(turnoId:Int): Turno?
    fun recuperarTodos(): List<Turno>
    fun recuperarTurnosDisponiblesPorHospitalYEspecialidad(hospital: Hospital, especialidad: Especialidad) : List<Turno>
    fun eliminar(turnoId:Int)
    fun clear()
}