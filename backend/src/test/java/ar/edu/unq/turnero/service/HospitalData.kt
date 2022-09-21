package ar.edu.unq.turnero.service

import ar.edu.unq.turnero.modelo.Especialidad
import ar.edu.unq.turnero.modelo.Hospital
import ar.edu.unq.turnero.modelo.Turno
import ar.edu.unq.turnero.persistence.HospitalDAO
import ar.edu.unq.turnero.persistence.TurnoDAO
import ar.edu.unq.turnero.service.impl.HospitalServiceImp
import ar.edu.unq.turnero.service.impl.TurnoServiceImp
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HospitalData {
    lateinit var service: HospitalService
    lateinit var turnoService: TurnoService

    @Autowired
    lateinit var hospitalDAO : HospitalDAO
    @Autowired
    lateinit var turnoDAO : TurnoDAO

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

    lateinit var turno: Turno

    var pediatria: Especialidad = Especialidad.PEDIATRIA
    var kinesiologia: Especialidad = Especialidad.KINESIOLOGIA
    var cardiologia: Especialidad = Especialidad.CARDIOLOGIA
    var urologia: Especialidad = Especialidad.UROLOGIA
    var traumatologia: Especialidad = Especialidad.TRAUMATOLOGIA
    var nefrologia: Especialidad = Especialidad.NEFROLOGIA
    var reumatologia: Especialidad = Especialidad.REUMATOLOGIA
    var oftalmologia: Especialidad = Especialidad.OFTALMOLOGIA
    var dermatologia: Especialidad = Especialidad.DERMATOLOGIA
    var oncologia: Especialidad = Especialidad.ONCOLOGIA

    @BeforeEach
    fun prepare() {
        this.service = HospitalServiceImp(hospitalDAO)
        this.turnoService = TurnoServiceImp(turnoDAO)

        evitaPueblo = Hospital(
            "Hospital Evita Pueblo",
            "Berazategui",
            "Calle Falsa 123",
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
            mutableListOf<Especialidad>()
        )
        iriarte.agregarEspecialidad(dermatologia)
        iriarte.agregarEspecialidad(urologia)
        iriarte.agregarEspecialidad(traumatologia)
        iriarte.agregarEspecialidad(nefrologia)
        service.crear(iriarte)

        miPueblo = Hospital(
            "Hospital Mi Pueblo",
            "Florencio Varela",
            "Florida 202",
            mutableListOf<Especialidad>()
        )
        miPueblo.agregarEspecialidad(pediatria)
        miPueblo.agregarEspecialidad(traumatologia)
        miPueblo.agregarEspecialidad(urologia)
        service.crear(miPueblo)

        interzonal = Hospital(
            "Hospital Interzonal de Agudos Evita",
            "Lanus",
            "Diego Armando Maradona 1910",
            mutableListOf<Especialidad>()
        )
        interzonal.agregarEspecialidad(pediatria)
        interzonal.agregarEspecialidad(traumatologia)
        interzonal.agregarEspecialidad(urologia)
        interzonal.agregarEspecialidad(nefrologia)
        interzonal.agregarEspecialidad(dermatologia)
        interzonal.agregarEspecialidad(reumatologia)
        service.crear(elCruce)

        garrahan = Hospital(
            "Hospital Garrahan",
            "CABA",
            "Pichincha 1890",
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
            mutableListOf<Especialidad>()
        )
        italianoCABA.agregarEspecialidad(pediatria)
        italianoCABA.agregarEspecialidad(traumatologia)
        italianoCABA.agregarEspecialidad(urologia)
        service.crear(italianoCABA)

        pirovano = Hospital(
            "Hospital Pirovano",
            "CABA",
            "Av. Monroe 3555",
            mutableListOf<Especialidad>()
        )
        pirovano.agregarEspecialidad(pediatria)
        pirovano.agregarEspecialidad(traumatologia)
        pirovano.agregarEspecialidad(urologia)
        pirovano.agregarEspecialidad(nefrologia)
        pirovano.agregarEspecialidad(dermatologia)
        pirovano.agregarEspecialidad(reumatologia)
        service.crear(elCruce)

        sanMartin = Hospital(
            "Hospital San Martin",
            "La Plata",
            "Calle 1 y 70,1900",
            mutableListOf<Especialidad>()
        )
        sanMartin.agregarEspecialidad(dermatologia)
        sanMartin.agregarEspecialidad(urologia)
        sanMartin.agregarEspecialidad(traumatologia)
        sanMartin.agregarEspecialidad(nefrologia)
        service.crear(sanMartin)

        sanRoque = Hospital(
            "Hospital San Roque",
            "La Plata",
            "Calle 508, 1897, Gonnet",
            mutableListOf<Especialidad>()
        )
        sanRoque.agregarEspecialidad(pediatria)
        sanRoque.agregarEspecialidad(traumatologia)
        sanRoque.agregarEspecialidad(urologia)
        service.crear(sanRoque)

        santamarina = Hospital(
            "Hospital Municipal Santa Marina",
            "Esteban Echeverria",
            "Gral. Alvear 350, Monte Grande",
            mutableListOf<Especialidad>()
        )
        santamarina.agregarEspecialidad(pediatria)
        santamarina.agregarEspecialidad(traumatologia)
        santamarina.agregarEspecialidad(urologia)
        santamarina.agregarEspecialidad(nefrologia)
        santamarina.agregarEspecialidad(dermatologia)
        santamarina.agregarEspecialidad(reumatologia)
        service.crear(santamarina)

        bocalandro = Hospital(
            "Hospital Dr. Carlos Bocalandro",
            "Tres de Febrero",
            "RP8 Nº9100 Km. 20,5, Loma Hermosa",
            mutableListOf<Especialidad>()
        )
        bocalandro.agregarEspecialidad(dermatologia)
        bocalandro.agregarEspecialidad(urologia)
        bocalandro.agregarEspecialidad(traumatologia)
        bocalandro.agregarEspecialidad(nefrologia)
        service.crear(bocalandro)

        italianoLP = Hospital(
            "Hospital Italiano",
            "La Plata",
            "Av. 51",
            mutableListOf<Especialidad>()
        )
        italianoLP.agregarEspecialidad(pediatria)
        italianoLP.agregarEspecialidad(traumatologia)
        italianoLP.agregarEspecialidad(urologia)
        service.crear(italianoLP)

        sanJuan = Hospital(
            "Hospital San Juan de Dios",
            "CABA",
            "Santa Rosa 1355",
            mutableListOf<Especialidad>()
        )
        sanJuan.agregarEspecialidad(pediatria)
        sanJuan.agregarEspecialidad(traumatologia)
        sanJuan.agregarEspecialidad(urologia)
        sanJuan.agregarEspecialidad(nefrologia)
        sanJuan.agregarEspecialidad(dermatologia)
        sanJuan.agregarEspecialidad(reumatologia)
        service.crear(sanJuan)

        arturoOnativia = Hospital(
            "Hospital Dr. Arturo Oñativia",
            "Rafael Calzada",
            "Dr. Ramon Carillo, 1339",
            mutableListOf<Especialidad>()
        )
        arturoOnativia.agregarEspecialidad(dermatologia)
        arturoOnativia.agregarEspecialidad(urologia)
        arturoOnativia.agregarEspecialidad(traumatologia)
        arturoOnativia.agregarEspecialidad(nefrologia)
        service.crear(arturoOnativia)

        sanCayetano = Hospital(
            "Hospital Municipal San Cayetano",
            "Virreyes",
            "Av. Avellaneda y Chile 4850",
            mutableListOf<Especialidad>()
        )
        sanCayetano.agregarEspecialidad(pediatria)
        sanCayetano.agregarEspecialidad(traumatologia)
        sanCayetano.agregarEspecialidad(urologia)
        service.crear(sanCayetano)

        presidentePeron = Hospital(
            "Hospital Presidente Peron",
            "Avellaneda",
            "Antole France 773, Sarandi",
            mutableListOf<Especialidad>()
        )
        presidentePeron.agregarEspecialidad(pediatria)
        presidentePeron.agregarEspecialidad(traumatologia)
        presidentePeron.agregarEspecialidad(urologia)
        presidentePeron.agregarEspecialidad(nefrologia)
        presidentePeron.agregarEspecialidad(dermatologia)
        presidentePeron.agregarEspecialidad(reumatologia)
        service.crear(presidentePeron)

        ramonSarda = Hospital(
            "Hospital Materno Infantil Ramon Sarda",
            "CABA",
            "Esteban de Luca 2151",
            mutableListOf<Especialidad>()
        )
        ramonSarda.agregarEspecialidad(dermatologia)
        ramonSarda.agregarEspecialidad(urologia)
        ramonSarda.agregarEspecialidad(traumatologia)
        ramonSarda.agregarEspecialidad(nefrologia)
        ramonSarda.agregarEspecialidad(pediatria)
        service.crear(ramonSarda)

        argerich = Hospital(
            "Hospital Gral. de Agudos Dr. Cosme Argerich",
            "CABA",
            "Pi y Margall 750",
            mutableListOf<Especialidad>()
        )
        argerich.agregarEspecialidad(pediatria)
        argerich.agregarEspecialidad(traumatologia)
        argerich.agregarEspecialidad(urologia)
        argerich.agregarEspecialidad(nefrologia)
        argerich.agregarEspecialidad(dermatologia)
        argerich.agregarEspecialidad(reumatologia)
        service.crear(argerich)

        joseCPaz = Hospital(
            "Hospital Oncologico De Jose C. Paz",
            "Jose C. Paz",
            "Av. Hector Arregui 501",
            mutableListOf<Especialidad>()
        )
        joseCPaz.agregarEspecialidad(dermatologia)
        joseCPaz.agregarEspecialidad(urologia)
        joseCPaz.agregarEspecialidad(traumatologia)
        joseCPaz.agregarEspecialidad(nefrologia)
        service.crear(joseCPaz)

        turno = Turno("Jose Perez", 38611455, traumatologia.toString(), "Leonardo Sanchez", sanRoque.nombre!!)

         turnoService.crear(turno)
    }

    @Test
    fun seCreaHospitalTest() {
        /*
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

        Assert.assertEquals(wilde, wildeRecuperado)

         */
    }


}