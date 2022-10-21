package ar.edu.unq.turnero.spring.controller

import ar.edu.unq.turnero.service.UsuarioService
import ar.edu.unq.turnero.spring.controller.DTOs.MiniUsuarioDTO
import ar.edu.unq.turnero.spring.controller.DTOs.UsuarioDTO
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.servlet.http.HttpServletResponse

@RestController
@CrossOrigin(maxAge = 3600, allowCredentials = "true")
@RequestMapping("/usuario")
class UsuarioController(private val usuarioService: UsuarioService) {

    @PostMapping("/register")
    fun register(@RequestBody usuario: UsuarioDTO, response: HttpServletResponse) : ResponseEntity<Any> {
        usuarioService.crear(usuario.aModelo())

        response.setHeader("Access-Control-Expose-Headers", "*");

        return ResponseEntity.ok().body("Ok")
    }

    @PostMapping("/login")
    fun login(@RequestBody usuario: MiniUsuarioDTO, response: HttpServletResponse) : ResponseEntity<Any> {
        val user = usuarioService.recuperarPorEmail(usuario.email!!)
        val issuer = user!!.id.toString()

        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + 60 * 24 * 1000))
            .signWith(SignatureAlgorithm.HS512, "secret").compact()

        response.setHeader("Authorization", jwt);
        response.setHeader("Access-Control-Expose-Headers", "*");

        return ResponseEntity.ok().body(user)
    }

    @GetMapping("/{usuariolId}")
    fun recuperar(@PathVariable usuarioId: Long) = UsuarioDTO.desdeModelo(usuarioService.recuperar(usuarioId.toInt())!!)

    @GetMapping("")
    fun recuperarTodos() = usuarioService.recuperarTodos().map { usuario -> UsuarioDTO.desdeModelo(usuario)  }
}