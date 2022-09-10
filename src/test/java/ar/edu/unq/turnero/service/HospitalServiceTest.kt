package ar.edu.unq.turnero.service

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

    @Autowired
    lateinit var hospitalDao : HospitalDAO
    lateinit var evitaPueblo: Hospital

    @BeforeEach
    fun prepare() {
        this.service = HospitalServiceImp(hospitalDao)
    }

    @Test
    fun seCreaHospitalTest() {
        evitaPueblo = Hospital("Hospital Evita Pueblo", "Berazategui", "Calle Falsa 123")
        val hospital = service.crear(evitaPueblo)

        val hospitalId = hospital.id!!.toInt()
        var evitaPuebloRecuperado = service.recuperar(hospitalId)

        Assert.assertEquals(evitaPueblo, evitaPuebloRecuperado)
    }

    @AfterEach
    fun cleanup() {
    }
}