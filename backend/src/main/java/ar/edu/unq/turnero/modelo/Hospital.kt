package ar.edu.unq.turnero.modelo

import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption
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

    @OneToMany(mappedBy = "hospital",  cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    var turnos: MutableList<Turno> = mutableListOf()

    @ElementCollection ( fetch = FetchType.EAGER)
    @CollectionTable(name = "hospital_especialidades")
    @JoinColumn(name = "hospital_id")
    @Column(name = "especialidad")
    @Enumerated(EnumType.STRING)
    var especialidades: MutableList<Especialidad> = mutableListOf<Especialidad>()

    constructor(nombre: String, municipio: String, direccion: String, especialidades: MutableList<Especialidad>, turnos: MutableList<Turno>):this() {
        this.nombre = nombre
        this.municipio = municipio
        this.direccion = direccion
        this.especialidades = especialidades
        this.turnos = turnos
    }

    fun agregarEspecialidad(nuevaEspecialidad: Especialidad) {
        this.especialidades.add(nuevaEspecialidad)
    }

    fun agregarTurno(nuevaTurno: Turno) {
        this.turnos.add(nuevaTurno)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Hospital

        if (id != other.id) return false
        if (nombre != other.nombre) return false
        if (municipio != other.municipio) return false
        if (direccion != other.direccion) return false

        return true
    }
}