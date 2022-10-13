package ar.edu.unq.turnero.modelo

import ar.edu.unq.turnero.modelo.exception.StringVacioException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.*

@Entity
class Turno() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @Column(nullable = false, length = 500)
    var nombreYApellidoPaciente: String? = ""
    var dniPaciente: Long? = null
    var telefonoPaciente: Long? = null
    var emailPaciente: String? = ""
    var fechaYHora: String? = null
    var fechaEmitido: String? = null
    var especialidad: Especialidad? = null
    var especialista: String? = null

    @ManyToOne
    //@JoinColumn(name = "hospital_id")
    var hospital: Hospital? = null

    constructor(nombre: String, dni: Long, telefono: Long, email: String, fechaYHora: String, fecha: String, especialidad: Especialidad?, especialista: String, hospital: Hospital?):this() {
        this.nombreYApellidoPaciente = nombre
        this.dniPaciente = dni
        this.telefonoPaciente = telefono
        this.emailPaciente = email
        this.fechaYHora = fechaYHora
        this.fechaEmitido = fecha
        this.especialidad = especialidad
        this.especialista = especialista
        this.hospital = hospital
    }

    constructor(fecha: String, especialidad: Especialidad?, especialista: String, hospital: Hospital?):this() {
        this.fechaYHora = fecha
        this.especialidad = especialidad
        this.especialista = especialista
        this.hospital = hospital
    }

    fun cambiarNombrePaciente(nombreNuevo: String) {
        if(nombreNuevo == "") {
            throw StringVacioException()
        }
        this.nombreYApellidoPaciente = nombreNuevo
    }

    fun cambiarDniPaciente(nuevoDNI: Long) {
        if(nuevoDNI.toString().length != 8) {
            throw Exception() //ErrorIntegerException()
        }
        this.dniPaciente = nuevoDNI
    }

    fun cambiarTelefonoPaciente(nuevoTelefono: Long) {
        if(nuevoTelefono.toString().length != 10) {
            throw Exception() //ErrorIntegerException()
        }
        this.telefonoPaciente = nuevoTelefono
    }

    fun cambiarEmailPaciente(nuevoEmail: String) {
        if(nuevoEmail == "") {
            throw StringVacioException()
        }
        this.emailPaciente = nuevoEmail
    }

    fun cambiarFechaEmitido() {
        this.fechaEmitido = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a"))
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Turno

        if (id != other.id) return false
        if (nombreYApellidoPaciente != other.nombreYApellidoPaciente) return false
        if (dniPaciente != other.dniPaciente) return false
        if (telefonoPaciente != other.telefonoPaciente) return false
        if (emailPaciente != other.emailPaciente) return false
        if (fechaYHora != other.fechaYHora) return false
        if (especialidad != other.especialidad) return false
        if (especialista != other.especialista) return false
        if (hospital != other.hospital) return false

        return true
    }

}