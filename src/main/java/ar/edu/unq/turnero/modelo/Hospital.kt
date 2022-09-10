package ar.edu.unq.turnero.modelo

import javax.persistence.*

@Entity
class Hospital() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @Column(nullable = false, length = 500)
    var nombre: String? = null
    var zona: String? = null
    var direccion: String? = null

    constructor(nombre: String, zona: String, direccion: String):this() {
        this.nombre = nombre
        this.zona = zona
        this.direccion = direccion
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Hospital

        if (id != other.id) return false
        if (nombre != other.nombre) return false
        if (zona != other.zona) return false
        if (direccion != other.direccion) return false

        return true
    }

}