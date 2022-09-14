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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="hospital_especialidades",
        joinColumns= [JoinColumn(name="hospital_id", referencedColumnName="id")],
        inverseJoinColumns= [JoinColumn(name="especialidad", referencedColumnName="id")]
    )
    var especialidades: MutableList<Especialidad> = mutableListOf<Especialidad>()

    constructor(nombre: String, zona: String, direccion: String, especialidades: MutableList<Especialidad>):this() {
        this.nombre = nombre
        this.zona = zona
        this.direccion = direccion
        this.especialidades = especialidades
    }

    fun agregarEspecialidad(nuevaEspecialidad: Especialidad) {
        this.especialidades.add(nuevaEspecialidad)
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