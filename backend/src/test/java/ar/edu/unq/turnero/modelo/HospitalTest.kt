package ar.edu.unq.turnero.modelo

import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class HospitalTest {

    lateinit var miPueblo: Hospital
    lateinit var interzonal: Hospital
    lateinit var pediatria: Especialidad


    var especialidades1: MutableList<Especialidad> = mutableListOf<Especialidad>()
    var especialidades2: MutableList<Especialidad> = mutableListOf<Especialidad>()

    @BeforeEach
    fun prepare(){
        miPueblo = Hospital("Hospital Mi Pueblo", "Florencio Varela", "Florida 202", "https://agenhoy.com.ar/trabajo-en-conjunto-para-enfrentar-al-coronavirus/", especialidades1)
        interzonal= Hospital("Hospital Interzonal de Agudos Evita", "Lanus", "Diego Armando Maradona 1910", "https://www.laopinionsemanario.com.ar/noticia/se-acabo-la-espera-autorizaron-el-traslado-de-luciana-betancourt/", especialidades2)
        pediatria = Especialidad("Pediatria")
    }

    @Test
    fun constructorTest(){
        Assert.assertEquals("Hospital Mi Pueblo", miPueblo.nombre)
        Assert.assertEquals("Florencio Varela", miPueblo.municipio)
        Assert.assertEquals("Florida 202", miPueblo.direccion)
        Assert.assertEquals(0, miPueblo.especialidades.size)

    }

    @Test
    fun seAgregaEspecialidadesAlHospitalTest(){

        Assert.assertEquals(0, miPueblo.especialidades.size)
        miPueblo.agregarEspecialidad(pediatria)
        Assert.assertEquals(1, miPueblo.especialidades.size)
    }

}