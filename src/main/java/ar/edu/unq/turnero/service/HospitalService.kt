package ar.edu.unq.turnero.service

import ar.edu.unq.turnero.modelo.Hospital

interface HospitalService {
    fun crear(hospital:Hospital): Hospital
    fun actualizar(hospital:Hospital): Hospital
    fun recuperar(hospitalId:Int): Hospital?
    fun eliminar(hospitalId:Int)
    fun recuperarTodos(): List<Hospital>
    fun clear()

}