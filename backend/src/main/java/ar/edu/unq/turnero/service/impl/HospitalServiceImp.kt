package ar.edu.unq.turnero.service.impl

import ar.edu.unq.turnero.modelo.Especialidad
import ar.edu.unq.turnero.modelo.Hospital
import ar.edu.unq.turnero.modelo.Turno
import ar.edu.unq.turnero.modelo.exception.ErrorSelectionException
import ar.edu.unq.turnero.modelo.exception.StringVacioException
import ar.edu.unq.turnero.persistence.HospitalDAO
import ar.edu.unq.turnero.service.HospitalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
open class HospitalServiceImp(
    @Autowired
    private val hospitalDAO: HospitalDAO
    ) : HospitalService {

    override fun crear(hospital: Hospital): Hospital {
        this.validarCampos(hospital)
        return hospitalDAO.save(hospital)
    }

    private fun validarCampos(hospital : Hospital) {
        if(hospital.nombre == "" || hospital.direccion == "" || hospital.municipio == "") {
            throw StringVacioException()
        }
    }

    override fun recuperar(hospitalId:Int): Hospital {
        val hospital = hospitalDAO.findByIdOrNull(hospitalId.toLong())
        if (hospital == null) {
            throw RuntimeException("El id [${hospitalId}] no existe.")
        }
        return hospital
    }

    override fun recuperarTodos():List<Hospital> {
        return hospitalDAO.findAllByOrderByNombreAsc()
    }

    // Dado un nombre devuelve una lista de hospitales cuyo nombre contiene el termino de busqueda.
    override fun recuperarPorNombre(nombre: String) : List<Hospital> {
        return hospitalDAO.findByNombreContaining(nombre)
    }

    override fun recuperarPorMunicipio(busqueda: String): List<Hospital> {
        hospitalDAO.findByMunicipioContaining(busqueda)
        return hospitalDAO.findByMunicipioContaining(busqueda)
    }

    override fun recuperarPorEspecialidad(busqueda: String): List<Hospital> {
       // hospitalDAO.findByEspecialidad(busqueda)
        return hospitalDAO.findByEspecialidad(busqueda)
        //var lista : List<Hospital> = listOf()
        //return lista
    }

    // Las especialidades quedan como string en MAYUSCULA
    override fun especialidadesDeHospital(idDeHospital: Int): MutableList<String> {
        var hospital : Hospital = recuperar(idDeHospital)
        var especialidades : List<Especialidad> = hospital.especialidades
        var especialidadesComoString : MutableList<String> = mutableListOf()
        especialidades.map{ e -> especialidadesComoString.add(e.toString()) }
        return especialidadesComoString
    }

    override fun recuperarTurnosDisponiblesPorEspecialidad(idDeHospital: Int, especialidad: Especialidad): List<Turno> {
        var hospital : Hospital = recuperar(idDeHospital)
        var turnos = hospital.turnos
        println(turnos)
        println(turnos.size)
        var turnosDisponibles : MutableList<Turno> = mutableListOf()
        turnos.map{ t -> if (t.especialidad == especialidad && t.dniPaciente == null) {turnosDisponibles.add(t)} }
        return turnosDisponibles
    }

    override fun recuperarPor(select: String, busqueda: String):List<Hospital>  {
        if (select == "nombre") {
            return this.recuperarPorNombre(busqueda)
        } else if (select == "municipio") {
            return this.recuperarPorMunicipio(busqueda)
        } else if ( select == "especialidad"){
            return this.recuperarPorEspecialidad(busqueda)
        } else {
            throw ErrorSelectionException()
        }
    }

    override fun clear() {
        hospitalDAO.deleteAll()
    }

}