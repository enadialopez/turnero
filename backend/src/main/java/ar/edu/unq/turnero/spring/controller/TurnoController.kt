package ar.edu.unq.turnero.spring.controller

import ar.edu.unq.turnero.service.TurnoService
import ar.edu.unq.turnero.spring.controller.DTOs.HospitalDTO
import ar.edu.unq.turnero.spring.controller.DTOs.TurnoDTO
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/turno")
class TurnoController(private val turnoService: TurnoService) {

    @PostMapping
    fun crear(@RequestBody turno: TurnoDTO) = turnoService.crear(turno.aModelo())

    @GetMapping("/{turnoId}")
    fun recuperar(@PathVariable turnoId: Long) = TurnoDTO.desdeModelo(turnoService.recuperar(turnoId.toInt())!!)

    @GetMapping("")
    fun recuperarTodos() = turnoService.recuperarTodos().map { turno -> TurnoDTO.desdeModelo(turno)  }

    @PutMapping("/{turnoId}")
    fun actualizar(@PathVariable turnoId: Long, @RequestBody turno: TurnoDTO) {
        var hospitalRecuperado = turnoService.recuperar(turnoId.toInt())!!
        turnoService.actualizar(turno.aModelo(hospitalRecuperado))
    }
}