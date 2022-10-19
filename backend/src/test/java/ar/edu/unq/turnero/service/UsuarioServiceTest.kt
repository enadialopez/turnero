package ar.edu.unq.turnero.service

import ar.edu.unq.turnero.modelo.Usuario
import ar.edu.unq.turnero.modelo.exception.StringVacioException
import ar.edu.unq.turnero.persistence.UsuarioDAO
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

    @Autowired
    lateinit var usuarioDAO: UsuarioDAO

    @BeforeEach
    fun prepare() {
        usuarioService = UsuarioServiceImp(usuarioDAO)
    }

    @Test
    fun seCreaUnUsuarioValido() {
        var user: Usuario = Usuario(24456734, "123", "Candela Aguayo",
            "candelaAguayo@yahoo.com", 42073821)
        usuarioService.crear(user)

        Assertions.assertNotNull(user.id)
    }

    @Test
    fun seCreaUnUsuarioInvalidoPorFaltaDeContrasenia() {
        var user: Usuario = Usuario(24456734, "", "Candela Aguayo",
            "candelaAguayo@yahoo.com", 42073821)

        try {
            usuarioService.crear(user)
        } catch (e: StringVacioException) {
            Assertions.assertEquals("El string no puede ser vacío.", e.message)
        }
    }

    @Test
    fun seRecuperaUnUsuarioDeFormaCorrecta() {
        var user: Usuario = Usuario(24456734, "123", "Candela Aguayo",
            "candelaAguayo@yahoo.com", 42073821)
        usuarioService.crear(user)

        var userId: Long? = user.id
        var userCreado: Usuario? = usuarioService.recuperar(userId!!.toInt())

        Assertions.assertNotNull(user.equals(userCreado))
    }

    @Test
    fun seIntentaRecuperaUnUsuarioQueNoExiste() {
        var user: Usuario = Usuario(24456734, "123", "Candela Aguayo",
            "candelaAguayo@yahoo.com", 42073821)
        var userId: Long? = user.id

        try {
            var userCreado: Usuario? = usuarioService.recuperar(userId!!.toInt())
        } catch (e: RuntimeException) { }
    }

    @Test
    fun seRecuperanTodosLosUsuariosDeFormaCorrecta() {
        var user1: Usuario = Usuario(24456734, "123", "Candela Aguayo",
            "candelaAguayo@yahoo.com", 42073821)
        var user2: Usuario = Usuario(13456734, "456", "Marcos Galante",
            "marcosGalante@gmail.com", 42073821)
        var user3: Usuario = Usuario(33456734, "789", "Ximena Jida",
            "ximeJida@hotmail.com", 42073821)

        usuarioService.crear(user1)
        usuarioService.crear(user2)
        usuarioService.crear(user3)

        var usuarios = usuarioService.recuperarTodos()

        Assertions.assertEquals(3, usuarios.size)
    }

    @AfterEach
    fun cleanUp(){
        usuarioService.clear()
    }

}