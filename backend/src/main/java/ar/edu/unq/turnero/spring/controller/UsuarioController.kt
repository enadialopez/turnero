package ar.edu.unq.turnero.spring.controller

import ar.edu.unq.turnero.service.UsuarioService
import ar.edu.unq.turnero.spring.controller.DTOs.MiniUsuarioDTO
import ar.edu.unq.turnero.spring.controller.DTOs.UsuarioDTO
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.servlet.http.HttpServletResponse

@RestController
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RequestMapping("/usuario")
class UsuarioController(private val usuarioService: UsuarioService) {

    @PostMapping("/register")
    fun register(@RequestBody usuario: UsuarioDTO, response: HttpServletResponse) : ResponseEntity<Any> {
        val user = usuarioService.crear(usuario.aModelo())
        val issuer = user!!.id.toString()
        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + 60 * 24 * 1000))
            .signWith(SignatureAlgorithm.HS512, "secret").compact()
        response.addHeader("Authorization", jwt)
        user.token = jwt
        val userResponse = usuarioService.actualizar(user)
        return ResponseEntity.ok().body(userResponse)
    }

    @PostMapping("/login")
    fun login(@RequestBody usuario: MiniUsuarioDTO, response: HttpServletResponse) : ResponseEntity<Any> {
        val user = usuarioService.recuperarPorEmail(usuario.email!!)
        val issuer = user!!.id.toString()
        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + 60 * 24 * 2000))
            .signWith(SignatureAlgorithm.HS512, "secret").compact()
        response.addHeader("Authorization", jwt)
        user.token = jwt
        val userResponse = usuarioService.actualizar(user)
        return ResponseEntity.ok().body(userResponse)
    }

    @GetMapping("")
    fun recuperar(@RequestHeader(HttpHeaders.AUTHORIZATION) token: String) : ResponseEntity<Any> {
        val user = usuarioService.recuperarPorToken(token)
        return ResponseEntity.ok().body(UsuarioDTO.desdeModelo(user!!))
    }

    @GetMapping("/todos")
    fun recuperarTodos() = usuarioService.recuperarTodos().map { usuario -> UsuarioDTO.desdeModelo(usuario)  }
}