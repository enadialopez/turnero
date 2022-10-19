package ar.edu.unq.turnero.spring.controller

import ar.edu.unq.turnero.service.UsuarioService
import ar.edu.unq.turnero.spring.controller.DTOs.UsuarioDTO
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/usuario")
class UsuarioController(private val usuarioService: UsuarioService) {

    @PostMapping
    fun crear(@RequestBody usuario: UsuarioDTO) = usuarioService.crear(usuario.aModelo())

    @GetMapping("/{usuariolId}")
    fun recuperar(@PathVariable usuarioId: Long) = UsuarioDTO.desdeModelo(usuarioService.recuperar(usuarioId.toInt())!!)

    @GetMapping("")
    fun recuperarTodos() = usuarioService.recuperarTodos().map { usuario -> UsuarioDTO.desdeModelo(usuario)  }
}