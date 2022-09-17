package ar.edu.unq.turnero.spring.controller

import ar.edu.unq.turnero.service.EspecialidadService
import ar.edu.unq.turnero.spring.controller.DTOs.EspecialidadDTO
import ar.edu.unq.turnero.spring.controller.DTOs.HospitalDTO
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/especialidad")
class EspecialidadController(private val especialidadService: EspecialidadService) {

    @PostMapping
    fun crear(@RequestBody especialidad: EspecialidadDTO) = especialidadService.crear(especialidad.aModelo())

    @GetMapping("/{Id}")
    fun recuperar(@PathVariable especialidadId: Long) = EspecialidadDTO.desdeModelo(especialidadService.recuperar(especialidadId.toInt())!!)

    @GetMapping("")
    fun recuperarTodos() = especialidadService.recuperarTodos().map { especialidad -> EspecialidadDTO.desdeModelo(especialidad) }
}