package ar.edu.unq.turnero.service
import ar.edu.unq.turnero.modelo.Especialidad
import ar.edu.unq.turnero.modelo.Hospital
import ar.edu.unq.turnero.modelo.Turno
//import ar.edu.unq.turnero.modelo.exception.ErrorIntegerException
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
    lateinit var hospitalService: HospitalService

    @Autowired
    lateinit var turnoDAO: TurnoDAO
    @Autowired
    lateinit var hospitalDAO: HospitalDAO

    lateinit var evitaPueblo: Hospital
    lateinit var elCruce: Hospital

    lateinit var turno1Evita: Turno
    lateinit var turno2Evita: Turno
    lateinit var turno3Evita: Turno
    lateinit var turno1Wilde: Turno
    lateinit var turno2Wilde: Turno
    lateinit var turno1Iriarte: Turno
    lateinit var turno2Iriarte: Turno
    lateinit var turno3Iriarte: Turno

    var pediatria: Especialidad = Especialidad.PEDIATRIA
    var urologia: Especialidad = Especialidad.UROLOGIA
    var traumatologia: Especialidad = Especialidad.TRAUMATOLOGIA
    var nefrologia: Especialidad = Especialidad.NEFROLOGIA
    var reumatologia: Especialidad = Especialidad.REUMATOLOGIA
    var dermatologia: Especialidad = Especialidad.DERMATOLOGIA

    @BeforeEach
    fun prepare() {
        this.turnoService = TurnoServiceImp(turnoDAO)
        this.hospitalService = HospitalServiceImp(hospitalDAO, turnoDAO)

        evitaPueblo = Hospital("Hospital Evita Pueblo", "Berazategui", "Calle 136 2905", mutableListOf<Especialidad>(), mutableListOf<Turno>())
        evitaPueblo.agregarEspecialidad(pediatria)
        evitaPueblo.agregarEspecialidad(traumatologia)
        evitaPueblo.agregarEspecialidad(urologia)
        hospitalService.crear(evitaPueblo)

        elCruce = Hospital(
            "Hospital El Cruce - Nestor Kirchner",
            "Florencio Varela",
            "Av. Calchaquí 5401",
            mutableListOf<Especialidad>(),
            mutableListOf<Turno>()
        )
        elCruce.agregarEspecialidad(pediatria)
        elCruce.agregarEspecialidad(traumatologia)
        elCruce.agregarEspecialidad(urologia)
        elCruce.agregarEspecialidad(nefrologia)
        elCruce.agregarEspecialidad(dermatologia)
        elCruce.agregarEspecialidad(reumatologia)
        hospitalService.crear(elCruce)

        turno1Evita = Turno("20/10/2022         19:00 hs", pediatria, "Julieta Gomez", evitaPueblo)
        turno2Evita = Turno("08/11/2022         17:30 hs", pediatria, "Carlos Ameghino", evitaPueblo)
        turno3Evita = Turno("02/11/2022         11:15 hs", nefrologia, "Juana Molina", elCruce)
        turno1Wilde = Turno("11/12/2022         08.45 hs", traumatologia, "Camila Avendanio", elCruce)

        turnoService.crear(turno1Evita)
        turnoService.crear(turno2Evita)
        turnoService.crear(turno3Evita)
        turnoService.crear(turno1Wilde)
    }

    @Test
    fun `se crea un turno para el hospital Evita Pueblo`() {
        var turnoEvita = Turno("10/10/2022     10:00 hs", reumatologia, "Julieta Gomez", evitaPueblo)
        var turno = turnoService.crear(turnoEvita)

        val turnoId = turno.id!!.toInt()
        var turnoRecuperado = turnoService.recuperar(turnoId)

        Assert.assertEquals("", turnoRecuperado!!.nombreYApellidoPaciente)
        Assert.assertEquals(null, turnoRecuperado!!.dniPaciente)
        Assert.assertEquals(reumatologia, turnoRecuperado!!.especialidad)
        Assert.assertEquals("Julieta Gomez", turnoRecuperado!!.especialista)
        Assert.assertEquals("10/10/2022     10:00 hs", turnoRecuperado!!.fechaYHora)
        Assert.assertEquals(null , turnoRecuperado!!.fechaEmitido)
        Assert.assertEquals(evitaPueblo.nombre, turnoRecuperado!!.hospital!!.nombre)

        Assert.assertEquals(turnoEvita, turnoRecuperado)
    }

    @Test
    fun `no se puede crear un turno para el hospital Evita Pueblo porque no tiene una fecha asignada`() {
        var turnoEvita = Turno("", reumatologia, "Julieta Gomez", evitaPueblo)
        try {
            turnoService.crear(turnoEvita)
            Assertions.fail("Expected a StringVacioException to be thrown")
        } catch (e: StringVacioException) {
            Assertions.assertEquals("El string no puede ser vacío.", e.message)
        }
    }

    @Test
    fun `no se puede crear un turno para el hospital Evita Pueblo porque no tiene una especialidad asignada`() {
        var turnoEvita = Turno("10/10/2022     10:00 hs", null, "Julieta Gomez", evitaPueblo)
        try {
            turnoService.crear(turnoEvita)
            Assertions.fail("Expected a StringVacioException to be thrown")
        } catch (e: StringVacioException) {
            Assertions.assertEquals("El string no puede ser vacío.", e.message)
        }
    }

    @Test
    fun `no se puede crear un turno para el hospital Evita Pueblo porque no tiene un especialista asignado`() {
        var turnoEvita = Turno("10/10/2022     10:00 hs", reumatologia, "", evitaPueblo)
        try {
            turnoService.crear(turnoEvita)
            Assertions.fail("Expected a StringVacioException to be thrown")
        } catch (e: StringVacioException) {
            Assertions.assertEquals("El string no puede ser vacío.", e.message)
        }
    }

    @Test
    fun `no se puede crear un turno para el hospital Evita Pueblo porque no tiene un hospital asignado`() {
        var turnoEvita = Turno("", reumatologia, "Julieta Gomez", null)
        try {
            turnoService.crear(turnoEvita)
            Assertions.fail("Expected a StringVacioException to be thrown")
        } catch (e: StringVacioException) {
            Assertions.assertEquals("El string no puede ser vacío.", e.message)
        }
    }

    @Test
    fun `se actualiza un turno para el paciente Jorge Perez`() {
        var turnoEvita = Turno("10/10/2022     10:00 hs", reumatologia, "Julieta Gomez", evitaPueblo)
        var turno = turnoService.crear(turnoEvita)
        var turnoId = turno.id!!.toInt()

        var turnoRecuperado = turnoService.recuperar(turnoId)

        Assert.assertEquals("", turnoRecuperado!!.nombreYApellidoPaciente)
        Assert.assertEquals(null, turnoRecuperado!!.dniPaciente)
        Assert.assertEquals(null, turnoRecuperado!!.telefonoPaciente)
        Assert.assertEquals("", turnoRecuperado!!.emailPaciente)
        Assert.assertEquals("10/10/2022     10:00 hs", turnoRecuperado!!.fechaYHora)
        Assert.assertEquals(reumatologia, turnoRecuperado!!.especialidad)
        Assert.assertEquals("Julieta Gomez", turnoRecuperado!!.especialista)
        Assert.assertEquals(evitaPueblo.nombre, turnoRecuperado!!.hospital!!.nombre)

        turnoEvita.cambiarNombrePaciente("Jorge Perez")
        turnoEvita.cambiarDniPaciente(22345678)
        turnoEvita.cambiarTelefonoPaciente(1123456789)
        turnoEvita.cambiarEmailPaciente("jorgePerez@gmail.com")
        turnoService.actualizar(turnoEvita)

        turnoRecuperado = turnoService.recuperar(turnoId)

        Assert.assertEquals("Jorge Perez", turnoRecuperado!!.nombreYApellidoPaciente)
        Assert.assertEquals(22345678, turnoRecuperado!!.dniPaciente)
        Assert.assertEquals(1123456789, turnoRecuperado!!.telefonoPaciente)
        Assert.assertEquals("jorgePerez@gmail.com", turnoRecuperado!!.emailPaciente)
    }

    @Test
    fun `no se puede actualizar un turno porque el nombre y apellido del paciente es vacio`() {
        var turnoEvita = Turno("10/10/2022     10:00 hs", reumatologia, "Julieta Gomez", evitaPueblo)
        var turno = turnoService.crear(turnoEvita)
        var turnoId = turno.id!!.toInt()

        var turnoRecuperado = turnoService.recuperar(turnoId)

        Assert.assertEquals("", turnoRecuperado!!.nombreYApellidoPaciente)
        try {
            turnoEvita.cambiarNombrePaciente("")
            turnoService.actualizar(turnoEvita)
            Assertions.fail("Expected a StringVacioException to be thrown")
        } catch (e: StringVacioException) {
            Assertions.assertEquals("El string no puede ser vacío.", e.message)
        }
    }

    @Test
    fun `no se puede actualizar un turno porque el email del paciente es vacio`() {
        var turnoEvita = Turno("10/10/2022     10:00 hs", reumatologia, "Julieta Gomez", evitaPueblo)
        var turno = turnoService.crear(turnoEvita)
        var turnoId = turno.id!!.toInt()

        var turnoRecuperado = turnoService.recuperar(turnoId)

        Assert.assertEquals("", turnoRecuperado!!.nombreYApellidoPaciente)
        try {
            turnoEvita.cambiarEmailPaciente("")
            turnoService.actualizar(turnoEvita)
            Assertions.fail("Expected a StringVacioException to be thrown")
        } catch (e: StringVacioException) {
            Assertions.assertEquals("El string no puede ser vacío.", e.message)
        }
    }

    /*
    @Test
    fun `no se puede actualizar un turno porque el dni pasado no cumple con la validacion`() {
        var turnoEvita = Turno("10/10/2022     10:00 hs", reumatologia, "Julieta Gomez", evitaPueblo)
        var turno = turnoService.crear(turnoEvita)
        var turnoId = turno.id!!.toInt()

        var turnoRecuperado = turnoService.recuperar(turnoId)

        Assert.assertEquals(null, turnoRecuperado!!.dniPaciente)
        try {
            turnoEvita.cambiarDniPaciente(0)
            turnoService.actualizar(turnoEvita)
            Assertions.fail("Expected a ErrorIntegerException to be thrown")
        } catch (e: ErrorIntegerException) {
            Assertions.assertEquals("El numero pasado no puede ser menor a los digitos del atributo.", e.message)
        }
    }

     */

    @Test
    fun seRecuperanLosTurnosDelHospitalEvitaEnPediatria() {
        var turnos = turnoService.recuperarTurnosDisponiblesPorHospitalYEspecialidad(evitaPueblo!!, pediatria)

        Assertions.assertEquals(2, turnos.size)
    }




    @AfterEach
    fun cleanUp(){
        turnoService.clear()
        hospitalService.clear()
    }
}