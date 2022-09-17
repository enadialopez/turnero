package ar.edu.unq.turnero.modelo

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.*

@Entity
class Turno() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @Column(nullable = false, length = 500)
    var nombreYApellidoPaciente: String? = null
    var dniPaciente: Long? = null
    var fechaYHora: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a"))
    var especialidad: String? = null
    var especialista: String? = null
    var hospital: String? = null

    constructor(nombre: String, dni: Long, fechaYHora: String, especialidad: String, especialista: String, hospital: String):this() {
        this.nombreYApellidoPaciente = nombre
        this.dniPaciente = dni
        this.fechaYHora = fechaYHora
        this.especialidad = especialidad
        this.especialista = especialista
        this.hospital = hospital
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Turno

        if (id != other.id) return false
        if (nombreYApellidoPaciente != other.nombreYApellidoPaciente) return false
        if (dniPaciente != other.dniPaciente) return false
        if (fechaYHora != other.fechaYHora) return false
        if (especialidad != other.especialidad) return false
        if (especialista != other.especialista) return false
        if (hospital != other.hospital) return false

        return true
    }

}