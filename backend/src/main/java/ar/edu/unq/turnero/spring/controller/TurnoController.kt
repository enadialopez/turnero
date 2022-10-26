package ar.edu.unq.turnero.spring.controller

import ar.edu.unq.turnero.service.TurnoService
import ar.edu.unq.turnero.spring.controller.DTOs.TurnoDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/turno")
class TurnoController(private val turnoService: TurnoService) {

    @PostMapping
    fun crear(@RequestBody turno: TurnoDTO) = turnoService.crear(turno.aModelo())

    @PutMapping("/{turnoId}")
    fun actualizar(@PathVariable turnoId: Long, @RequestBody turno: TurnoDTO) : ResponseEntity<Any>  {
        var turnoRecuperado = turnoService.recuperar(turnoId.toInt())!!
        val turno = turnoService.actualizar(turno.aModelo(turnoRecuperado))
        return ResponseEntity.ok().body(turno)
    }

    @GetMapping("/{turnoId}")
    fun recuperar(@PathVariable turnoId: Long) = TurnoDTO.desdeModelo(turnoService.recuperar(turnoId.toInt())!!)

    @GetMapping("")
    fun recuperarTodos() = turnoService.recuperarTodos().map { turno -> TurnoDTO.desdeModelo(turno)  }
}