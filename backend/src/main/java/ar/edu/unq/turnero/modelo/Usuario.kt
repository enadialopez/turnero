package ar.edu.unq.turnero.modelo

import javax.persistence.*

@Entity
class Usuario() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @Column(nullable = false, length = 500)
    var nombreYApellido: String? = null
    var image: String? = null
    var dni: Long? = null
    var telefono: Long? = null
    var token: String? = null
    var password: String? = null
    @Column(unique = true)
    var email: String? = null

    //@OneToMany(mappedBy = "paciente", cascade = [CascadeType.PERSIST, CascadeType.MERGE],
    //    orphanRemoval = false, fetch = FetchType.LAZY)
    //var turnosAsignados: MutableList<Turno> = mutableListOf<Turno>()

    constructor(nombreYApellido: String, image: String?, dni: Long, email: String, telefono: Long, password: String):this() {
        this.nombreYApellido = nombreYApellido
        this.image = image
        this.dni = dni
        this.email = email
        this.telefono = telefono
        this.password = password
    }

    constructor(nombreYApellido: String, dni: Long):this() {
        this.nombreYApellido = nombreYApellido
        this.dni = dni
    }

    fun sacarTurno(turno: Turno) {
        //this.turnosAsignados.add(turno)
        turno.asignarAPaciente(this)
    }
/*
    fun cancelarTurno(turno: Turno) {
        turnosAsignados.map{ t -> if (t.equals(turno)) {
            t.desasignarAPaciente()
            turnosAsignados.remove(t)} }
    }
*/
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Usuario

        if (id != other.id) return false
        if (nombreYApellido != other.nombreYApellido) return false
        if (image != other.image) return false
        if (dni != other.dni) return false
        if (email != other.email) return false
        if (telefono != other.telefono) return false
        if (password != other.password) return false

        return true
    }
}