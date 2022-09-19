package ar.edu.unq.turnero.service

import ar.edu.unq.turnero.modelo.Hospital

interface HospitalService {
    fun crear(hospital:Hospital): Hospital
    fun recuperar(hospitalId:Int): Hospital?
    fun recuperarTodos(): List<Hospital>
    fun recuperarPor(select: String, busqueda: String): List<Hospital>
    fun recuperarPorNombre(busqueda: String): List<Hospital>
    fun recuperarPorMunicipio(busqueda: String): List<Hospital>
    fun recuperarPorEspecialidad(busqueda: String): List<Hospital>
    fun clear()

}