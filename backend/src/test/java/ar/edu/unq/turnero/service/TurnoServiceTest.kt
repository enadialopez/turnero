package ar.edu.unq.turnero.service
import ar.edu.unq.turnero.modelo.Especialidad
import ar.edu.unq.turnero.modelo.Hospital
import ar.edu.unq.turnero.modelo.Turno
import ar.edu.unq.turnero.modelo.exception.ErrorSelectionException
import ar.edu.unq.turnero.modelo.exception.StringVacioException
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
class TurnoServiceTest {

    lateinit var turnoService: TurnoService

    @Autowired
    lateinit var turnoDAO: TurnoDAO

    lateinit var turno1Evita: Turno
    lateinit var turno2Evita: Turno
    lateinit var turno3Evita: Turno
    lateinit var turno1Wilde: Turno
    lateinit var turno2Wilde: Turno
    lateinit var turno1Iriarte: Turno
    lateinit var turno2Iriarte: Turno
    lateinit var turno3Iriarte: Turno

    @BeforeEach
    fun prepare() {
        this.turnoService = TurnoServiceImp(turnoDAO)

        turno1Evita = Turno("Pediatria", "Julieta Gomez", "Evita")
        turno2Evita = Turno("Pediatria", "Carlos Ameghino", "Evita")
        turno3Evita = Turno("Ginecologia", "Juana Molina", "Evita")
        turno1Wilde = Turno("Pediatria", "Camila Avendanio", "Wilde")

        turnoService.crear(turno1Evita)
        turnoService.crear(turno2Evita)
        turnoService.crear(turno3Evita)
        turnoService.crear(turno1Wilde)
    }

    @Test
    fun seRecuperanLosTurnosDelHospitalEvitaEnPediatria() {
        var turnos = turnoService.recuperarTurnosDisponiblesPorHospitalYEspecialidad("Evita", "Pediatria")

        Assertions.assertEquals(2, turnos.size)
    }


    @AfterEach
    fun cleanUp(){
        turnoService.clear()
    }
}