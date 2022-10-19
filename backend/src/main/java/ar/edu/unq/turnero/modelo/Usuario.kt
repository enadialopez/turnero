package ar.edu.unq.turnero.modelo

import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption
import javax.persistence.*

@Entity
class Usuario() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @Column(nullable = false, length = 500)
    var contraseña: String? = null
    var nombreYApellido: String? = null
    var dni: Long? = null
    var email: String? = null
    var telefono: Long? = null
    /*
    @OneToMany(mappedBy = "paciente",  cascade = [CascadeType.ALL], orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    var turnosAsignados: MutableList<Turno> = mutableListOf<Turno>()
     */

    constructor(dni: Long, contraseña: String, nombreYApellido: String, email: String, telefono: Long):this() {
        this.contraseña = contraseña
        this.nombreYApellido = nombreYApellido
        this.dni = dni
        this.email = email
        this.telefono = telefono
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Usuario

        if (id != other.id) return false
        if (contraseña != other.contraseña) return false
        if (nombreYApellido != other.nombreYApellido) return false
        if (dni != other.dni) return false
        if (email != other.email) return false
        if (telefono != other.telefono) return false

        return true
    }
}