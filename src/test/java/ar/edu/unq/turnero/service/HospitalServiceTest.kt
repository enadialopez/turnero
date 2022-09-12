package ar.edu.unq.turnero.service

import ar.edu.unq.turnero.modelo.Especialidad
import ar.edu.unq.turnero.modelo.Hospital
import ar.edu.unq.turnero.persistence.*
import ar.edu.unq.turnero.service.impl.*
import org.junit.Assert
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
@TestInstance(PER_CLASS)
class HospitalServiceTest {

    lateinit var service: HospitalService
    lateinit var serviceEspecialidad: EspecialidadService

    @Autowired
    lateinit var hospitalDAO : HospitalDAO
    @Autowired
    lateinit var especialidadDAO : EspecialidadDAO

    lateinit var evitaPueblo: Hospital
    lateinit var elCruce: Hospital
    lateinit var quilmes: Hospital

    lateinit var pediatria: Especialidad
    lateinit var kinesiologia: Especialidad
    lateinit var cardiologia: Especialidad
    lateinit var urologia: Especialidad
    lateinit var traumatologia: Especialidad
    lateinit var nefrologia: Especialidad
    lateinit var reumatologia: Especialidad
    lateinit var oftalmologia: Especialidad
    lateinit var dermatologia: Especialidad

    var especialidades: MutableList<Especialidad> = mutableListOf<Especialidad>()

    @BeforeEach
    fun prepare() {
        this.service = HospitalServiceImp(hospitalDAO)
        this.serviceEspecialidad = EspecialidadServiceImp(especialidadDAO)

        pediatria = Especialidad("Pediatria")
        kinesiologia = Especialidad("Kinesiologia")
        cardiologia = Especialidad("Cardiologia")
        urologia = Especialidad("Urologia")
        traumatologia = Especialidad("Traumatologia")
        nefrologia = Especialidad("Nefrologia")
        reumatologia = Especialidad("Reumatologia")
        oftalmologia = Especialidad("Oftalmologia")
        dermatologia = Especialidad("Dermatologia")

        serviceEspecialidad.crear(pediatria)
        serviceEspecialidad.crear(cardiologia)
        serviceEspecialidad.crear(urologia)
        serviceEspecialidad.crear(traumatologia)

        evitaPueblo = Hospital("Hospital Evita Pueblo", "Berazategui", "Calle Falsa 123", especialidades)
        evitaPueblo.agregarEspecialidad(pediatria)
        evitaPueblo.agregarEspecialidad(traumatologia)
        evitaPueblo.agregarEspecialidad(urologia)
        service.crear(evitaPueblo)

        elCruce = Hospital("Hospital El Cruce - Nestor Kirchner", "Florencio Varela", "Calle Falsa 123", especialidades)
        service.crear(elCruce)

        quilmes = Hospital("Hospital Quilmes - Isidoro Iriarte", "Quilmes", "Calle Falsa 123", especialidades)
        service.crear(quilmes)
    }


    @Test
    fun seCreaHospitalTest() {
        evitaPueblo = Hospital("Hospital Evita Pueblo", "Berazategui", "Calle Falsa 123", especialidades)
        val hospital = service.crear(evitaPueblo)

        val hospitalId = hospital.id!!.toInt()
        var evitaPuebloRecuperado = service.recuperar(hospitalId)

        Assert.assertEquals(evitaPueblo, evitaPuebloRecuperado)
    }



    @AfterEach
    fun cleanup() {
    }
}