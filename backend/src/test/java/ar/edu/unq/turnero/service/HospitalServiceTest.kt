package ar.edu.unq.turnero.service

import ar.edu.unq.turnero.modelo.Especialidad
import ar.edu.unq.turnero.modelo.Hospital
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
    lateinit var serviceEspecialidad: EspecialidadService

    @Autowired
    lateinit var hospitalDAO : HospitalDAO
    @Autowired
    lateinit var especialidadDAO : EspecialidadDAO

    lateinit var evitaPueblo: Hospital
    lateinit var elCruce: Hospital
    lateinit var iriarte: Hospital
    lateinit var miPueblo: Hospital
    lateinit var interzonal: Hospital
    lateinit var garrahan: Hospital
    lateinit var italianoCABA: Hospital
    lateinit var pirovano: Hospital
    lateinit var sanMartin: Hospital
    lateinit var sanRoque: Hospital
    lateinit var santamarina: Hospital
    lateinit var bocalandro: Hospital
    lateinit var italianoLP: Hospital
    lateinit var sanJuan: Hospital
    lateinit var arturoOnativia: Hospital
    lateinit var presidentePeron: Hospital
    lateinit var ramonSarda: Hospital
    lateinit var argerich: Hospital
    lateinit var sanCayetano: Hospital
    lateinit var joseCPaz: Hospital

    lateinit var pediatria: Especialidad
    lateinit var kinesiologia: Especialidad
    lateinit var cardiologia: Especialidad
    lateinit var urologia: Especialidad
    lateinit var traumatologia: Especialidad
    lateinit var nefrologia: Especialidad
    lateinit var reumatologia: Especialidad
    lateinit var oftalmologia: Especialidad
    lateinit var dermatologia: Especialidad

    var especialidades1: MutableList<Especialidad> = mutableListOf<Especialidad>()
    var especialidades2: MutableList<Especialidad> = mutableListOf<Especialidad>()
    var especialidades3: MutableList<Especialidad> = mutableListOf<Especialidad>()
    var especialidades4: MutableList<Especialidad> = mutableListOf<Especialidad>()
    var especialidades5: MutableList<Especialidad> = mutableListOf<Especialidad>()
    var especialidades6: MutableList<Especialidad> = mutableListOf<Especialidad>()
    var especialidades7: MutableList<Especialidad> = mutableListOf<Especialidad>()
    var especialidades8: MutableList<Especialidad> = mutableListOf<Especialidad>()
    var especialidades9: MutableList<Especialidad> = mutableListOf<Especialidad>()
    var especialidades10: MutableList<Especialidad> = mutableListOf<Especialidad>()
    var especialidades11: MutableList<Especialidad> = mutableListOf<Especialidad>()
    var especialidades12: MutableList<Especialidad> = mutableListOf<Especialidad>()
    var especialidades13: MutableList<Especialidad> = mutableListOf<Especialidad>()
    var especialidades14: MutableList<Especialidad> = mutableListOf<Especialidad>()
    var especialidades15: MutableList<Especialidad> = mutableListOf<Especialidad>()
    var especialidades16: MutableList<Especialidad> = mutableListOf<Especialidad>()
    var especialidades17: MutableList<Especialidad> = mutableListOf<Especialidad>()
    var especialidades18: MutableList<Especialidad> = mutableListOf<Especialidad>()
    var especialidades19: MutableList<Especialidad> = mutableListOf<Especialidad>()
    var especialidades20: MutableList<Especialidad> = mutableListOf<Especialidad>()
    @BeforeEach
    fun prepare() {
        this.service = HospitalServiceImp(hospitalDAO)
        this.serviceEspecialidad = EspecialidadServiceImp(especialidadDAO)

        pediatria = Especialidad("Pediatria")
        kinesiologia = Especialidad("Kinesiologia")
        cardiologia = Especialidad("Cardiologia")
        urologia = Especialidad("Urologia")
        traumatologia = Especialidad("Traumatologia")
        nefrologia = Especialidad("Nefrologia")
        reumatologia = Especialidad("Reumatologia")
        oftalmologia = Especialidad("Oftalmologia")
        dermatologia = Especialidad("Dermatologia")

        serviceEspecialidad.crear(pediatria)
        serviceEspecialidad.crear(kinesiologia)
        serviceEspecialidad.crear(cardiologia)
        serviceEspecialidad.crear(urologia)
        serviceEspecialidad.crear(traumatologia)
        serviceEspecialidad.crear(nefrologia)
        serviceEspecialidad.crear(reumatologia)
        serviceEspecialidad.crear(oftalmologia)
        serviceEspecialidad.crear(dermatologia)

        evitaPueblo = Hospital("Hospital Evita Pueblo", "Berazategui", "Calle Falsa 123", "https://agenhoy.com.ar/trabajo-en-conjunto-para-enfrentar-al-coronavirus/", especialidades1)
        evitaPueblo.agregarEspecialidad(pediatria)
        evitaPueblo.agregarEspecialidad(traumatologia)
        evitaPueblo.agregarEspecialidad(urologia)
        service.crear(evitaPueblo)

        elCruce = Hospital("Hospital El Cruce - Nestor Kirchner", "Florencio Varela", "Calle Falsa 123", "https://www.laopinionsemanario.com.ar/noticia/se-acabo-la-espera-autorizaron-el-traslado-de-luciana-betancourt/", especialidades2)
        elCruce.agregarEspecialidad(pediatria)
        elCruce.agregarEspecialidad(traumatologia)
        elCruce.agregarEspecialidad(urologia)
        elCruce.agregarEspecialidad(nefrologia)
        elCruce.agregarEspecialidad(dermatologia)
        elCruce.agregarEspecialidad(reumatologia)
        service.crear(elCruce)

        iriarte = Hospital("Hospital Quilmes - Isidoro Iriarte", "Quilmes", "Calle Falsa 123", "https://quilmesenred.com/el-hospital-iriarte-fue-premiado-en-el-congreso-de-salud-que-se-realizo-en-mar-del-plata/", especialidades3)
        iriarte.agregarEspecialidad(dermatologia)
        iriarte.agregarEspecialidad(urologia)
        iriarte.agregarEspecialidad(traumatologia)
        iriarte.agregarEspecialidad(nefrologia)
        service.crear(iriarte)

        miPueblo = Hospital("Hospital Mi Pueblo", "Florencio Varela", "Florida 202", "https://agenhoy.com.ar/trabajo-en-conjunto-para-enfrentar-al-coronavirus/", especialidades4)
        miPueblo.agregarEspecialidad(pediatria)
        miPueblo.agregarEspecialidad(traumatologia)
        miPueblo.agregarEspecialidad(urologia)
        service.crear(miPueblo)

        interzonal= Hospital("Hospital Interzonal de Agudos Evita", "Lanus", "Diego Armando Maradona 1910", "https://www.laopinionsemanario.com.ar/noticia/se-acabo-la-espera-autorizaron-el-traslado-de-luciana-betancourt/", especialidades5)
        interzonal.agregarEspecialidad(pediatria)
        interzonal.agregarEspecialidad(traumatologia)
        interzonal.agregarEspecialidad(urologia)
        interzonal.agregarEspecialidad(nefrologia)
        interzonal.agregarEspecialidad(dermatologia)
        interzonal.agregarEspecialidad(reumatologia)
        service.crear(elCruce)

        garrahan = Hospital("Hospital Garrahan", "CABA", "Pichincha 1890", "https://quilmesenred.com/el-hospital-iriarte-fue-premiado-en-el-congreso-de-salud-que-se-realizo-en-mar-del-plata/", especialidades6)
        garrahan.agregarEspecialidad(dermatologia)
        garrahan.agregarEspecialidad(urologia)
        garrahan.agregarEspecialidad(traumatologia)
        garrahan.agregarEspecialidad(nefrologia)
        service.crear(garrahan)

        italianoCABA = Hospital("Hospital Italiano de Buenos Aires", "CABA", "Av. Juan Bautista Alberdi 439", "https://agenhoy.com.ar/trabajo-en-conjunto-para-enfrentar-al-coronavirus/", especialidades7)
        italianoCABA.agregarEspecialidad(pediatria)
        italianoCABA.agregarEspecialidad(traumatologia)
        italianoCABA.agregarEspecialidad(urologia)
        service.crear(italianoCABA)

        pirovano = Hospital("Hospital Pirovano", "CABA", "Av. Monroe 3555", "https://www.laopinionsemanario.com.ar/noticia/se-acabo-la-espera-autorizaron-el-traslado-de-luciana-betancourt/", especialidades8)
        pirovano.agregarEspecialidad(pediatria)
        pirovano.agregarEspecialidad(traumatologia)
        pirovano.agregarEspecialidad(urologia)
        pirovano.agregarEspecialidad(nefrologia)
        pirovano.agregarEspecialidad(dermatologia)
        pirovano.agregarEspecialidad(reumatologia)
        service.crear(elCruce)

        sanMartin = Hospital("Hospital San Martin", "La Plata", "Calle 1 y 70,1900", "https://quilmesenred.com/el-hospital-iriarte-fue-premiado-en-el-congreso-de-salud-que-se-realizo-en-mar-del-plata/", especialidades9)
        sanMartin.agregarEspecialidad(dermatologia)
        sanMartin.agregarEspecialidad(urologia)
        sanMartin.agregarEspecialidad(traumatologia)
        sanMartin.agregarEspecialidad(nefrologia)
        service.crear(sanMartin)

        sanRoque = Hospital("Hospital San Roque", "La Plata", "Calle 508, 1897, Gonnet", "https://agenhoy.com.ar/trabajo-en-conjunto-para-enfrentar-al-coronavirus/", especialidades10)
        sanRoque.agregarEspecialidad(pediatria)
        sanRoque.agregarEspecialidad(traumatologia)
        sanRoque.agregarEspecialidad(urologia)
        service.crear(sanRoque)

        santamarina = Hospital("Hospital Municipal Santa Marina", "Esteban Echeverria", "Gral. Alvear 350, Monte Grande", "https://www.laopinionsemanario.com.ar/noticia/se-acabo-la-espera-autorizaron-el-traslado-de-luciana-betancourt/", especialidades11)
        santamarina.agregarEspecialidad(pediatria)
        santamarina.agregarEspecialidad(traumatologia)
        santamarina.agregarEspecialidad(urologia)
        santamarina.agregarEspecialidad(nefrologia)
        santamarina.agregarEspecialidad(dermatologia)
        santamarina.agregarEspecialidad(reumatologia)
        service.crear(santamarina)

        bocalandro = Hospital("Hospital Dr. Carlos Bocalandro", "Tres de Febrero", "RP8 Nº9100 Km. 20,5, Loma Hermosa", "https://quilmesenred.com/el-hospital-iriarte-fue-premiado-en-el-congreso-de-salud-que-se-realizo-en-mar-del-plata/", especialidades12)
        bocalandro.agregarEspecialidad(dermatologia)
        bocalandro.agregarEspecialidad(urologia)
        bocalandro.agregarEspecialidad(traumatologia)
        bocalandro.agregarEspecialidad(nefrologia)
        service.crear(bocalandro)

        italianoLP = Hospital("Hospital Italiano", "La Plata", "Av. 51", "https://agenhoy.com.ar/trabajo-en-conjunto-para-enfrentar-al-coronavirus/", especialidades13)
        italianoLP.agregarEspecialidad(pediatria)
        italianoLP.agregarEspecialidad(traumatologia)
        italianoLP.agregarEspecialidad(urologia)
        service.crear(italianoLP)

        sanJuan = Hospital("Hospital San Juan de Dios", "CABA", "Santa Rosa 1355", "https://www.laopinionsemanario.com.ar/noticia/se-acabo-la-espera-autorizaron-el-traslado-de-luciana-betancourt/", especialidades14)
        sanJuan.agregarEspecialidad(pediatria)
        sanJuan.agregarEspecialidad(traumatologia)
        sanJuan.agregarEspecialidad(urologia)
        sanJuan.agregarEspecialidad(nefrologia)
        sanJuan.agregarEspecialidad(dermatologia)
        sanJuan.agregarEspecialidad(reumatologia)
        service.crear(sanJuan)

        arturoOnativia = Hospital("Hospital Dr. Arturo Oñativia", "Rafael Calzada", "Dr. Ramon Carillo, 1339", "https://quilmesenred.com/el-hospital-iriarte-fue-premiado-en-el-congreso-de-salud-que-se-realizo-en-mar-del-plata/", especialidades15)
        arturoOnativia.agregarEspecialidad(dermatologia)
        arturoOnativia.agregarEspecialidad(urologia)
        arturoOnativia.agregarEspecialidad(traumatologia)
        arturoOnativia.agregarEspecialidad(nefrologia)
        service.crear(arturoOnativia)

        sanCayetano = Hospital("Hospital Municipal San Cayetano", "Virreyes", "Av. Avellaneda y Chile 4850", "https://agenhoy.com.ar/trabajo-en-conjunto-para-enfrentar-al-coronavirus/", especialidades16)
        sanCayetano.agregarEspecialidad(pediatria)
        sanCayetano.agregarEspecialidad(traumatologia)
        sanCayetano.agregarEspecialidad(urologia)
        service.crear(sanCayetano)

        presidentePeron = Hospital("Hospital Presidente Peron", "Avellaneda", "Antole France 773, Sarandi", "https://www.laopinionsemanario.com.ar/noticia/se-acabo-la-espera-autorizaron-el-traslado-de-luciana-betancourt/", especialidades17)
        presidentePeron.agregarEspecialidad(pediatria)
        presidentePeron.agregarEspecialidad(traumatologia)
        presidentePeron.agregarEspecialidad(urologia)
        presidentePeron.agregarEspecialidad(nefrologia)
        presidentePeron.agregarEspecialidad(dermatologia)
        presidentePeron.agregarEspecialidad(reumatologia)
        service.crear(presidentePeron)

        ramonSarda = Hospital("Hospital Materno Infantil Ramon Sarda", "CABA", "Esteban de Luca 2151", "https://quilmesenred.com/el-hospital-iriarte-fue-premiado-en-el-congreso-de-salud-que-se-realizo-en-mar-del-plata/", especialidades18)
        ramonSarda.agregarEspecialidad(dermatologia)
        ramonSarda.agregarEspecialidad(urologia)
        ramonSarda.agregarEspecialidad(traumatologia)
        ramonSarda.agregarEspecialidad(nefrologia)
        ramonSarda.agregarEspecialidad(pediatria)
        service.crear(ramonSarda)

        argerich = Hospital("Hospital Gral. de Agudos Dr. Cosme Argerich", "CABA", "Pi y Margall 750", "https://www.laopinionsemanario.com.ar/noticia/se-acabo-la-espera-autorizaron-el-traslado-de-luciana-betancourt/", especialidades19)
        argerich.agregarEspecialidad(pediatria)
        argerich.agregarEspecialidad(traumatologia)
        argerich.agregarEspecialidad(urologia)
        argerich.agregarEspecialidad(nefrologia)
        argerich.agregarEspecialidad(dermatologia)
        argerich.agregarEspecialidad(reumatologia)
        service.crear(argerich)

        joseCPaz = Hospital("Hospital Oncologico De Jose C. Paz", "Jose C. Paz", "Av. Hector Arregui 501", "https://quilmesenred.com/el-hospital-iriarte-fue-premiado-en-el-congreso-de-salud-que-se-realizo-en-mar-del-plata/", especialidades20)
        joseCPaz.agregarEspecialidad(dermatologia)
        joseCPaz.agregarEspecialidad(urologia)
        joseCPaz.agregarEspecialidad(traumatologia)
        joseCPaz.agregarEspecialidad(nefrologia)
        service.crear(joseCPaz)
    }

    @Test
    fun seCreaHospitalTest() {
        val wilde = Hospital("Hospital Zonal General de Agudos “Dr. E. Wilde”", "Quilmes", "Calle Falsa 123", "https://clinica-web.com.ar/listing/hospital-wilde/", mutableListOf<Especialidad>())
        wilde.agregarEspecialidad(traumatologia)
        wilde.agregarEspecialidad(nefrologia)
        val hospital = service.crear(wilde)

        val hospitalId = hospital.id!!.toInt()
        var wildeRecuperado = service.recuperar(hospitalId)

        Assert.assertEquals(wilde, wildeRecuperado)
    }

    @Test
    fun seRecuperaUnHospitalPorNombreNestorTest() {
        var hospitales = service.recuperarPorNombre("nestor")

        Assert.assertTrue(hospitales.contains(elCruce))
    }

    @Test
    fun seRecuperaUnHospitalPorEspecialidadTest() {
        var hospitales = service.recuperarPorEspecialidad("pediatria")

        Assert.assertTrue(hospitales.contains(elCruce))
    }

    /*@Test
    fun seRecuperaPorSegunLaSeleccion () {
        var hospitales = service.recuperarPor("pediatria", "especialidad")

        Assert.assertTrue(hospitales.contains(elCruce))
    }*/

    @AfterEach
    fun cleanUp(){
        service.clear()
    }
}