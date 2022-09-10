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
    private val hospitalDao: HospitalDAO
    ) : HospitalService {

    override fun crear(hospital: Hospital): Hospital {
        return hospitalDao.save(hospital)
    }

    override fun actualizar(hospital: Hospital): Hospital {
        return this.hospitalDao.save(hospital)
    }

    override fun recuperar(hospitalId:Int): Hospital {
        val hospital = hospitalDao.findByIdOrNull(hospitalId.toLong())
        if (hospital == null) {
            throw RuntimeException("El id [${hospitalId}] no existe.")
        }
        return hospital
    }

    override fun eliminar(hospitalId:Int) {
        this.recuperar(hospitalId)
        hospitalDao.deleteById(hospitalId.toLong())
    }

    override fun recuperarTodos():List<Hospital> {
        return hospitalDao.findAllByOrderByNombreAsc()
    }

    override fun clear() {
        hospitalDao.deleteAll()
    }

}