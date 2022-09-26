package ar.edu.unq.turnero.spring.controller

import ar.edu.unq.turnero.modelo.Especialidad
import ar.edu.unq.turnero.service.HospitalService
import ar.edu.unq.turnero.spring.controller.DTOs.HospitalDTO
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/hospital")
class HospitalController(private val hospitalService: HospitalService) {

    @PostMapping
    fun crear(@RequestBody hospital: HospitalDTO) = hospitalService.crear(hospital.aModelo())

    @GetMapping("/{hospitalId}")
    fun recuperar(@PathVariable hospitalId: Long) = HospitalDTO.desdeModelo(hospitalService.recuperar(hospitalId.toInt())!!)

    @GetMapping("/search")
    @ResponseBody
    fun recuperarPor(@RequestParam q: String, value: String) = hospitalService.recuperarPor(value, q).map { hospital -> HospitalDTO.desdeModelo(hospital)  }

    @GetMapping("")
    fun recuperarTodos() = hospitalService.recuperarTodos().map { hospital -> HospitalDTO.desdeModelo(hospital)  }

    /*
    @GetMapping("/{hospitalId}/{especialidad}/turnos")
    fun turnosDisponibles(@PathVariable hospitalId: Long, @PathVariable especialidad: Especialidad) =
        hospitalService.recuperarTurnosDisponiblesPorEspecialidad(hospitalId.toInt(), especialidad)

     */
}