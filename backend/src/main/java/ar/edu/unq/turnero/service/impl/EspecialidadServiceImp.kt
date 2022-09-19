package ar.edu.unq.turnero.service.impl

import ar.edu.unq.turnero.modelo.Especialidad
import ar.edu.unq.turnero.persistence.EspecialidadDAO
import ar.edu.unq.turnero.service.EspecialidadService
import ar.edu.unq.turnero.service.HospitalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
open class EspecialidadServiceImp(
    @Autowired
    private val especialidadDAO: EspecialidadDAO
) : EspecialidadService {

    override fun crear(especialidad: Especialidad): Especialidad {
        return especialidadDAO.save(especialidad)
    }

    override fun recuperar(especialidadId:Int): Especialidad {
        val especialidad = especialidadDAO.findByIdOrNull(especialidadId.toLong())
        if (especialidad == null) {
            throw RuntimeException("El id [${especialidadId}] no existe.")
        }
        return especialidad
    }

    override fun recuperarTodos():List<Especialidad> {
        return especialidadDAO.findAllByOrderByNombreAsc()
    }

    override fun clear() {
        especialidadDAO.deleteAll()
    }

}