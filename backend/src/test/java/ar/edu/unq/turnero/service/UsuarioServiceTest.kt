package ar.edu.unq.turnero.service

import ar.edu.unq.turnero.modelo.Especialidad
import ar.edu.unq.turnero.modelo.Hospital
import ar.edu.unq.turnero.modelo.Turno
import ar.edu.unq.turnero.modelo.Usuario
import ar.edu.unq.turnero.modelo.exception.StringVacioException
import ar.edu.unq.turnero.persistence.HospitalDAO
import ar.edu.unq.turnero.persistence.TurnoDAO
import ar.edu.unq.turnero.persistence.UsuarioDAO
import ar.edu.unq.turnero.service.impl.HospitalServiceImp
import ar.edu.unq.turnero.service.impl.TurnoServiceImp
import ar.edu.unq.turnero.service.impl.UsuarioServiceImp
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
class UsuarioServiceTest {

    lateinit var usuarioService: UsuarioService
    lateinit var hospitalService: HospitalService
    lateinit var turnoService: TurnoService

    @Autowired
    lateinit var usuarioDAO: UsuarioDAO
    @Autowired
    lateinit var hospitalDAO: HospitalDAO
    @Autowired
    lateinit var turnoDAO: TurnoDAO

    @BeforeEach
    fun prepare() {
        usuarioService = UsuarioServiceImp(usuarioDAO)
        turnoService = TurnoServiceImp(turnoDAO)
        hospitalService = HospitalServiceImp(hospitalDAO, turnoService)
    }

    @Test
    fun seCreaUnUsuarioValido() {
        var user: Usuario = Usuario("Candela Aguayo", 42073821, "candelaAguayo@yahoo.com",
            24456734, "123", null)
        usuarioService.crear(user)

        Assertions.assertNotNull(user.id)
    }

    @Test
    fun seCreaUnUsuarioInvalidoPorFaltaDeContrasenia() {
        var user: Usuario = Usuario("Candela Aguayo", 42073821, "candelaAguayo@yahoo.com",
            24456734, "", null)

        try {
            usuarioService.crear(user)
        } catch (e: StringVacioException) {
            Assertions.assertEquals("El string no puede ser vacío.", e.message)
        }
    }

    @Test
    fun seRecuperaUnUsuarioDeFormaCorrecta() {
        var user: Usuario = Usuario("Candela Aguayo", 42073821, "candelaAguayo@yahoo.com",
            24456734, "123", null)
        usuarioService.crear(user)

        var userId: Long? = user.id
        var userCreado: Usuario? = usuarioService.recuperar(userId!!.toInt())

        Assertions.assertNotNull(user.equals(userCreado))
    }

    @Test
    fun seIntentaRecuperaUnUsuarioQueNoExiste() {
        var user: Usuario = Usuario("Candela Aguayo", 42073821, "candelaAguayo@yahoo.com",
            24456734, "123", null)

        var userId: Long? = user.id

        try {
            var userCreado: Usuario? = usuarioService.recuperar(userId!!.toInt())
        } catch (e: RuntimeException) { }
    }

    @Test
    fun seRecuperanTodosLosUsuariosDeFormaCorrecta() {
        var user1: Usuario = Usuario("Candela Aguayo", 42073821, "candelaAguayo@yahoo.com",
            24456734, "123", null)
        var user2: Usuario = Usuario("Marcos Galante", 42073821, "marcosGalante@gmail.com",
            13456734, "456", null)
        var user3: Usuario = Usuario("Ximena Jida", 42073821, "ximeJida@hotmail.com",
            33456734, "789", null)

        usuarioService.crear(user1)
        usuarioService.crear(user2)
        usuarioService.crear(user3)

        var usuarios = usuarioService.recuperarTodos()

        Assertions.assertEquals(3, usuarios.size)
    }

    @Test
    fun userSacaTurnoDeFormaCorrecta(){
        var evitaPueblo = Hospital("Hospital Evita Pueblo", "Berazategui", "Calle 136 2905",        mutableListOf<Especialidad>(), mutableListOf<Turno>())
        var pediatria: Especialidad = Especialidad.PEDIATRIA
        var turnoEvita = Turno("20/10/2022         19:00 hs", pediatria, "Julieta Gomez", evitaPueblo)
        evitaPueblo.agregarTurno(turnoEvita)
        hospitalService.crear(evitaPueblo)

        var user: Usuario = Usuario("Candela Aguayo", 42073821, "candelaAguayo@yahoo.com", 1124456734, "123", null)
        usuarioService.crear(user)

        user.sacarTurno(turnoEvita)
        usuarioService.actualizar(user)

        var turnoCreado = turnoService.recuperar(turnoEvita.id!!.toInt())

        Assertions.assertEquals(1, user.turnosAsignados.size)
        Assertions.assertEquals(user, turnoCreado!!.paciente)
    }

    @AfterEach
    fun cleanUp(){
        turnoService.clear()
        hospitalService.clear()
        usuarioService.clear()
    }

}