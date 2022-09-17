package ar.edu.unq.turnero.modelo

import javax.persistence.*
@Entity
class Especialidad() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @Column(nullable = false, length = 500)
    var nombre: String? = null

    constructor(nombre: String):this() {
        this.nombre = nombre
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Hospital

        if (id != other.id) return false
        if (nombre != other.nombre) return false

        return true
    }
}