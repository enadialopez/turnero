package ar.edu.unq.turnero.modelo

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Usuario() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @Column(nullable = false, length = 500)
    var nickName: String? = null
    var contraseña: String? = null
    var nombreYApellido: String? = null
    var dni: Long? = null
    var email: String? = null
    var telefono: Long? = null

    constructor(nickName: String, dni: Long, contraseña: String, nombreYApellido: String, email: String, telefono: Long):this() {
        this.nickName = nickName
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
        if (nickName != other.nickName) return false
        if (contraseña != other.contraseña) return false
        if (nombreYApellido != other.nombreYApellido) return false
        if (dni != other.dni) return false
        if (email != other.email) return false
        if (telefono != other.telefono) return false

        return true
    }
}