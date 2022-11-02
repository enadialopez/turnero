package ar.edu.unq.turnero.spring.controller

import ar.edu.unq.turnero.service.TurnoService
import ar.edu.unq.turnero.spring.controller.DTOs.TurnoDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
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

    @GetMapping("/todos")
    fun recuperarTodos() = turnoService.recuperarTodos().map { turno -> TurnoDTO.desdeModelo(turno)  }

    @GetMapping("/todos/{hospitalId}/{especialidad}")
    fun turnosDisponibles(@PathVariable hospitalId: Long, @PathVariable especialidad: String) =
        turnoService.recuperarTurnosDisponiblesPorHospitalYEspecialidad(hospitalId.toInt(), especialidad).map { turno -> TurnoDTO.desdeModelo(turno) }
}