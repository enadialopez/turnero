package ar.edu.unq.turnero.service

import ar.edu.unq.turnero.modelo.Especialidad
import ar.edu.unq.turnero.modelo.Hospital
import ar.edu.unq.turnero.modelo.exception.ErrorSelectionException
import ar.edu.unq.turnero.modelo.exception.StringVacioException
import ar.edu.unq.turnero.persistence.*
import ar.edu.unq.turnero.service.impl.*
import org.junit.Assert
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
@TestInstance(PER_CLASS)
class HospitalServiceTest {

    lateinit var service: HospitalService

    @Autowired
    lateinit var hospitalDAO: HospitalDAO

    lateinit var evitaPueblo: Hospital
    lateinit var garrahan: Hospital
    lateinit var elCruce: Hospital
    lateinit var iriarte: Hospital
    lateinit var italianoCABA: Hospital

    var pediatria: Especialidad = Especialidad.PEDIATRIA
    var urologia: Especialidad = Especialidad.UROLOGIA
    var traumatologia: Especialidad = Especialidad.TRAUMATOLOGIA
    var nefrologia: Especialidad = Especialidad.NEFROLOGIA
    var reumatologia: Especialidad = Especialidad.REUMATOLOGIA
    var dermatologia: Especialidad = Especialidad.DERMATOLOGIA

    @BeforeEach
    fun prepare() {
        this.service = HospitalServiceImp(hospitalDAO)

        evitaPueblo = Hospital(
            "Hospital Evita Pueblo",
            "Berazategui",
            "Calle Falsa 123",
            "https://agenhoy.com.ar/trabajo-en-conjunto-para-enfrentar-al-coronavirus/",
            mutableListOf<Especialidad>()
        )
        evitaPueblo.agregarEspecialidad(pediatria)
        evitaPueblo.agregarEspecialidad(traumatologia)
        evitaPueblo.agregarEspecialidad(urologia)
        service.crear(evitaPueblo)

        elCruce = Hospital(
            "Hospital El Cruce - Nestor Kirchner",
            "Florencio Varela",
            "Calle Falsa 123",
            "https://www.laopinionsemanario.com.ar/noticia/se-acabo-la-espera-autorizaron-el-traslado-de-luciana-betancourt/",
            mutableListOf<Especialidad>()
        )
        elCruce.agregarEspecialidad(pediatria)
        elCruce.agregarEspecialidad(traumatologia)
        elCruce.agregarEspecialidad(urologia)
        elCruce.agregarEspecialidad(nefrologia)
        elCruce.agregarEspecialidad(dermatologia)
        elCruce.agregarEspecialidad(reumatologia)
        service.crear(elCruce)

        iriarte = Hospital(
            "Hospital Quilmes - Isidoro Iriarte",
            "Quilmes",
            "Calle Falsa 123",
            "https://quilmesenred.com/el-hospital-iriarte-fue-premiado-en-el-congreso-de-salud-que-se-realizo-en-mar-del-plata/",
            mutableListOf<Especialidad>()
        )
        iriarte.agregarEspecialidad(dermatologia)
        iriarte.agregarEspecialidad(urologia)
        iriarte.agregarEspecialidad(traumatologia)
        iriarte.agregarEspecialidad(nefrologia)
        service.crear(iriarte)

        garrahan = Hospital(
            "Hospital Garrahan",
            "CABA",
            "Pichincha 1890",
            "https://quilmesenred.com/el-hospital-iriarte-fue-premiado-en-el-congreso-de-salud-que-se-realizo-en-mar-del-plata/",
            mutableListOf<Especialidad>()
        )
        garrahan.agregarEspecialidad(dermatologia)
        garrahan.agregarEspecialidad(urologia)
        garrahan.agregarEspecialidad(traumatologia)
        garrahan.agregarEspecialidad(nefrologia)
        service.crear(garrahan)

        italianoCABA = Hospital(
            "Hospital Italiano de Buenos Aires",
            "CABA",
            "Av. Juan Bautista Alberdi 439",
            "https://agenhoy.com.ar/trabajo-en-conjunto-para-enfrentar-al-coronavirus/",
            mutableListOf<Especialidad>()
        )
        italianoCABA.agregarEspecialidad(pediatria)
        italianoCABA.agregarEspecialidad(traumatologia)
        italianoCABA.agregarEspecialidad(urologia)
        service.crear(italianoCABA)
    }

    @Test
    fun seCreaHospitalWildeTest() {
        val wilde = Hospital(
            "Hospital Zonal General de Agudos “Dr. E. Wilde”",
            "Quilmes",
            "Calle Falsa 123",
            "https://clinica-web.com.ar/listing/hospital-wilde/",
            mutableListOf<Especialidad>()
        )
        wilde.agregarEspecialidad(traumatologia)
        wilde.agregarEspecialidad(nefrologia)
        val hospital = service.crear(wilde)

        val hospitalId = hospital.id!!.toInt()
        var wildeRecuperado = service.recuperar(hospitalId)

        Assert.assertEquals("Hospital Zonal General de Agudos “Dr. E. Wilde”", wildeRecuperado!!.nombre)
        Assert.assertEquals("Quilmes", wildeRecuperado!!.municipio)
        Assert.assertEquals("Calle Falsa 123", wildeRecuperado!!.direccion)
        Assert.assertEquals(2, wildeRecuperado!!.especialidades.size)
        Assert.assertEquals(wilde, wildeRecuperado)
    }

    @Test
    fun NoSePuedeCrearUnHospitalSinNombreTest() {
        val hospital = Hospital("", "municipio", "direccion","", mutableListOf<Especialidad>())
        try {
            service.crear(hospital)
            Assertions.fail("Expected a StringVacioException to be thrown")
        } catch (e: StringVacioException) {
            Assertions.assertEquals("El string no puede ser vacío.", e.message)
        }
    }

    @Test
    fun NoSePuedeCrearUnHospitalSinMunicipioTest() {
        val wilde = Hospital(
            "Hospital Zonal General de Agudos “Dr. E. Wilde”",
            "",
            "Calle Falsa 123",
            "https://clinica-web.com.ar/listing/hospital-wilde/",
            mutableListOf<Especialidad>()
        )

        try {
            service.crear(wilde)
            Assertions.fail("Expected a StringVacioException to be thrown")
        } catch (e: StringVacioException) {
            Assertions.assertEquals(e.message, "El string no puede ser vacío.")
        }


    }

    @Test
    fun NoSePuedeCrearUnHospitalSinDireccionTest() {
        val wilde = Hospital(
            "Hospital Zonal General de Agudos “Dr. E. Wilde”",
            "Quilmes",
            "",
            "https://clinica-web.com.ar/listing/hospital-wilde/",
            mutableListOf<Especialidad>()
        )
        try {
            service.crear(wilde)
            Assertions.fail("Expected a StringVacioException to be thrown")
        } catch (e: StringVacioException) {
            Assertions.assertEquals("El string no puede ser vacío.", e.message)
        }
    }

    @Test
    fun seRecuperaUnHospitalPorNombreNestorTest() {
        var hospitales = service.recuperarPorNombre("nestor")

        Assert.assertEquals(1, hospitales!!.size)
        Assert.assertTrue(hospitales.contains(elCruce))
    }

    @Test
    fun seRecuperaUnHospitalPorElMunicipioQuilmesTest() {
        var hospitales = service.recuperarPorMunicipio("quilmes")

        Assert.assertEquals(1, hospitales!!.size)
        Assert.assertTrue(hospitales.contains(iriarte))
    }

    @Test
    fun seRecuperanHospitalesPorEspecialidadTest() {
        var hospitales = service.recuperarPorEspecialidad("pediatria")

        Assert.assertEquals(3, hospitales!!.size) // no funciona por query
        Assert.assertTrue(hospitales.contains(elCruce))
    }



    @Test
    fun seRecuperaPorLaEspecialidadPediatria() {
        var hospitales = service.recuperarPor("especialidad", "pediat")

        Assert.assertTrue(hospitales.contains(elCruce))
        Assert.assertTrue(elCruce.especialidades.contains(pediatria)) // no funciona por query
    }

    @Test
    fun noSePuedeRecuperaPorQueLaSeleccionNoExiste() {
        try {
            service.recuperarPor("berazategui", "oncologia")
            Assertions.fail("Expected a ErrorSelectionException to be thrown")
        } catch (e: ErrorSelectionException) {
            Assertions.assertEquals(e.message, "El valor pasado del selector no es correcto.")
        }
    }

    @Test
    fun seRecuperanLasEspecialidadesDeUnHospitalCorrectamente() {
        var idGarrahan = garrahan.id!!.toInt()
        var especialidades = service.especialidadesDeHospital(idGarrahan)
        println(especialidades)
        Assertions.assertTrue(especialidades.contains("DERMATOLOGIA"))
        Assertions.assertTrue(especialidades.contains("UROLOGIA"))
        Assertions.assertTrue(especialidades.contains("TRAUMATOLOGIA"))
        Assertions.assertTrue(especialidades.contains("NEFROLOGIA"))
        Assertions.assertFalse(especialidades.contains("PEDIATRIA"))
    }

    @AfterEach
    fun cleanUp(){
        service.clear()
    }
}