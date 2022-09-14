package ar.edu.unq.turnero.service.impl

import ar.edu.unq.turnero.modelo.Hospital
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
        return hospitalDAO.save(hospital)
    }

    override fun actualizar(hospital: Hospital): Hospital {
        return this.hospitalDAO.save(hospital)
    }

    override fun recuperar(hospitalId:Int): Hospital {
        val hospital = hospitalDAO.findByIdOrNull(hospitalId.toLong())
        if (hospital == null) {
            throw RuntimeException("El id [${hospitalId}] no existe.")
        }
        return hospital
    }

    override fun eliminar(hospitalId:Int) {
        this.recuperar(hospitalId)
        hospitalDAO.deleteById(hospitalId.toLong())
    }

    override fun recuperarTodos():List<Hospital> {
        return hospitalDAO.findAllByOrderByNombreAsc()
    }

    // Dado un nombre devuelve una lista de hospitales cuyo nombre contiene el termino de busqueda.
    override fun recuperarPorNombre(nombre: String) : List<Hospital> {
        return hospitalDAO.findByNombreContaining(nombre)
    }

    override fun recuperarPorZona(zona: String): List<Hospital> {
        return hospitalDAO.findByZonaContaining(zona)
    }

    override fun recuperarPorEspecialidad(especialidad: String): List<Hospital> {
        return hospitalDAO.recuperarPorEspecialidad(especialidad)
    }

    override fun clear() {
        hospitalDAO.deleteAll()
    }

}