package ar.edu.unq.turnero.modelo

import javax.persistence.*

@Entity
class Hospital() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @Column(nullable = false, length = 500)
    var nombre: String? = null
    var municipio: String? = null
    var direccion: String? = null
    var imagen: String? = null
    //@ManyToOne(fetch = FetchType.EAGER)
    //var especialidades: MutableList<Especialidad> = mutableListOf<Especialidad>()

    constructor(nombre: String, municipio: String, direccion: String, imagen: String, especialidades: MutableList<Especialidad>):this() {
        this.nombre = nombre
        this.municipio = municipio
        this.direccion = direccion
        this.imagen = imagen
        //.especialidades = especialidades
    }

    fun agregarEspecialidad(nuevaEspecialidad: Especialidad) {
        //this.especialidades.add(nuevaEspecialidad)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Hospital

        if (id != other.id) return false
        if (nombre != other.nombre) return false
        if (municipio != other.municipio) return false
        if (direccion != other.direccion) return false
        if (imagen != other.imagen) return false

        return true
    }


}