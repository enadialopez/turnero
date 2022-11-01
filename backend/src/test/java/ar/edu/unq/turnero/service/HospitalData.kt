package ar.edu.unq.turnero.service

import ar.edu.unq.turnero.modelo.Especialidad
import ar.edu.unq.turnero.modelo.Hospital
import ar.edu.unq.turnero.modelo.Turno
import ar.edu.unq.turnero.modelo.Usuario
import ar.edu.unq.turnero.persistence.HospitalDAO
import ar.edu.unq.turnero.persistence.TurnoDAO
import ar.edu.unq.turnero.persistence.UsuarioDAO
import ar.edu.unq.turnero.service.impl.HospitalServiceImp
import ar.edu.unq.turnero.service.impl.TurnoServiceImp
import ar.edu.unq.turnero.service.impl.UsuarioServiceImp
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
    lateinit var turnoService: TurnoService
    lateinit var service: HospitalService
    lateinit var usuarioService: UsuarioService

    @Autowired
    lateinit var hospitalDAO : HospitalDAO
    @Autowired
    lateinit var turnoDAO : TurnoDAO
    @Autowired
    lateinit var usuarioDAO : UsuarioDAO

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

    var user1: Usuario = Usuario("Candela Aguayo", null, 42073810, "candelaaguayo@yahoo.com",
    1124456734, "12345678")
    var user2: Usuario = Usuario("Marcos Galante", null, 42073822, "marcosgalante@gmail.com",
        1113456734, "45678912")
    var user3: Usuario = Usuario("Ximena Jida", null, 42043821, "ximejida@hotmail.com",
        1133456734, "78912345")

    @BeforeEach
    fun prepare() {
        this.turnoService = TurnoServiceImp(turnoDAO)
        this.service = HospitalServiceImp(hospitalDAO)
        this.usuarioService = UsuarioServiceImp(usuarioDAO, turnoService)

        usuarioService.crear(user1)
        usuarioService.crear(user2)
        usuarioService.crear(user3)

        evitaPueblo = Hospital(
            "Hospital Evita Pueblo",
            "Berazategui",
            "Calle 136 2905",
            mutableListOf<Especialidad>(),
            mutableListOf<Turno>()
        )
        evitaPueblo.agregarEspecialidad(pediatria)
        evitaPueblo.agregarEspecialidad(traumatologia)
        evitaPueblo.agregarEspecialidad(urologia)
        service.crear(evitaPueblo)

        var turnoEvita1 = Turno("27/12/2022     17:45 hs", pediatria, "Leonardo Sanchez", evitaPueblo)
        var turnoEvita2 = Turno("31/11/2022     12:00 hs", traumatologia, "Manuel Rodriguez", evitaPueblo)
        var turnoEvita3 = Turno("05/12/2022     09:15 hs", urologia, "Pablo Tobias", evitaPueblo)
        var turnoEvita4 = Turno("20/12/2022     10:00 hs", pediatria, "Leonardo Sanchez", evitaPueblo)
        var turnoEvita5 = Turno("27/12/2022     08:15 hs", pediatria, "Leonardo Sanchez", evitaPueblo)
        var turnoEvita6 = Turno("03/01/2023     09:15 hs", traumatologia, "Veronica Manini", evitaPueblo)
        var turnoEvita7 = Turno("03/01/2023     09:45 hs", traumatologia, "Veronica Manini", evitaPueblo)
        var turnoEvita8 = Turno("29/12/2022     14:30 hs", urologia, "Carlos Saenz", evitaPueblo)
        var turnoEvita9 = Turno("29/12/2022     15:00 hs", urologia, "Carlos Saenz", evitaPueblo)

        evitaPueblo.agregarTurno(turnoEvita1)
        evitaPueblo.agregarTurno(turnoEvita2)
        evitaPueblo.agregarTurno(turnoEvita3)
        evitaPueblo.agregarTurno(turnoEvita4)
        evitaPueblo.agregarTurno(turnoEvita5)
        evitaPueblo.agregarTurno(turnoEvita6)
        evitaPueblo.agregarTurno(turnoEvita7)
        evitaPueblo.agregarTurno(turnoEvita8)
        evitaPueblo.agregarTurno(turnoEvita9)

        turnoService.crear(turnoEvita1)
        turnoService.crear(turnoEvita2)
        turnoService.crear(turnoEvita3)
        turnoService.crear(turnoEvita4)
        turnoService.crear(turnoEvita5)
        turnoService.crear(turnoEvita6)
        turnoService.crear(turnoEvita7)
        turnoService.crear(turnoEvita8)
        turnoService.crear(turnoEvita9)

        service.actualizar(evitaPueblo)


        elCruce = Hospital(
            "Hospital El Cruce - Nestor Kirchner",
            "Florencio Varela",
            "Av. Calchaquí 5401",
            mutableListOf<Especialidad>(),
            mutableListOf<Turno>()
        )
        elCruce.agregarEspecialidad(pediatria)
        elCruce.agregarEspecialidad(traumatologia)
        elCruce.agregarEspecialidad(urologia)
        elCruce.agregarEspecialidad(nefrologia)
        elCruce.agregarEspecialidad(dermatologia)
        elCruce.agregarEspecialidad(reumatologia)
        service.crear(elCruce)

        var turnoElCruce1 = Turno("04/01/2023     17:45 hs", reumatologia, "Carla Esposito", elCruce)
        var turnoElCruce2 = Turno("05/01/2023     17:45 hs", reumatologia, "Carla Esposito", elCruce)
        var turnoElCruce3 = Turno("15/12/2022     16:00 hs", urologia, "Julian Carrasco", elCruce)
        var turnoElCruce4 = Turno("16/12/2022     16:00 hs", urologia, "Julian Carrasco", elCruce)
        var turnoElCruce5 = Turno("23/12/2022     08:00 hs", traumatologia, "Camila Gutierrez", elCruce)
        var turnoElCruce6 = Turno("23/12/2022     08:30 hs", traumatologia, "Camila Gutierrez", elCruce)
        var turnoElCruce7 = Turno("23/12/2022     09:00 hs", traumatologia, "Camila Gutierrez", elCruce)
        var turnoElCruce8 = Turno("04/01/2023     10:00 hs", nefrologia, "Iris Amato", elCruce)
        var turnoElCruce9 = Turno("04/01/2023     10:30 hs", nefrologia, "Iris Amato", elCruce)
        var turnoElCruce10 = Turno("03/01/2023     09:00 hs", dermatologia, "Luis Dandrea", elCruce)
        var turnoElCruce11 = Turno("03/01/2023     09:30 hs", dermatologia, "Luis Dandrea", elCruce)
        var turnoElCruce12 = Turno("03/01/2023     10:00 hs", dermatologia, "Luis Dandrea", elCruce)

        elCruce.agregarTurno(turnoElCruce1)
        elCruce.agregarTurno(turnoElCruce2)
        elCruce.agregarTurno(turnoElCruce3)
        elCruce.agregarTurno(turnoElCruce4)
        elCruce.agregarTurno(turnoElCruce5)
        elCruce.agregarTurno(turnoElCruce6)
        elCruce.agregarTurno(turnoElCruce7)
        elCruce.agregarTurno(turnoElCruce8)
        elCruce.agregarTurno(turnoElCruce9)
        elCruce.agregarTurno(turnoElCruce10)
        elCruce.agregarTurno(turnoElCruce11)
        elCruce.agregarTurno(turnoElCruce12)

        service.actualizar(elCruce)

        iriarte = Hospital(
            "Hospital Quilmes - Isidoro Iriarte",
            "Quilmes",
            "Allison Bell N°770",
            mutableListOf<Especialidad>(),
            mutableListOf<Turno>()
        )
        iriarte.agregarEspecialidad(dermatologia)
        iriarte.agregarEspecialidad(urologia)
        iriarte.agregarEspecialidad(traumatologia)
        iriarte.agregarEspecialidad(nefrologia)
        service.crear(iriarte)

        var turnoIriarte1 = Turno("15/12/2022     16:00 hs", urologia, "Sandra Vicunia", iriarte)
        var turnoIriarte2 = Turno("16/12/2022     16:00 hs", urologia, "Sandra Vicunia", iriarte)
        var turnoIriarte3 = Turno("23/12/2022     08:00 hs", traumatologia, "Mateo Viña", iriarte)
        var turnoIriarte4 = Turno("23/12/2022     08:30 hs", traumatologia, "Mateo Viña", iriarte)
        var turnoIriarte5 = Turno("23/12/2022     09:00 hs", traumatologia, "Mateo Viña", iriarte)
        var turnoIriarte6 = Turno("04/01/2023     10:00 hs", nefrologia, "Karina Paso", iriarte)
        var turnoIriarte7 = Turno("04/01/2023     10:30 hs", nefrologia, "Karina Paso", iriarte)
        var turnoIriarte8 = Turno("04/01/2023     11:00 hs", nefrologia, "Karina Paso", iriarte)
        var turnoIriarte9 = Turno("03/01/2023     09:30 hs", dermatologia, "Pedro Dandrea", iriarte)
        var turnoIriarte10 = Turno("03/01/2023     10:00 hs", dermatologia, "Pedro Dandrea", iriarte)

        iriarte.agregarTurno(turnoIriarte1)
        iriarte.agregarTurno(turnoIriarte2)
        iriarte.agregarTurno(turnoIriarte3)
        iriarte.agregarTurno(turnoIriarte4)
        iriarte.agregarTurno(turnoIriarte5)
        iriarte.agregarTurno(turnoIriarte6)
        iriarte.agregarTurno(turnoIriarte7)
        iriarte.agregarTurno(turnoIriarte8)
        iriarte.agregarTurno(turnoIriarte9)
        iriarte.agregarTurno(turnoIriarte10)

        service.actualizar(iriarte)


        miPueblo = Hospital(
            "Hospital Mi Pueblo",
            "Florencio Varela",
            "Florida 202",
            mutableListOf<Especialidad>(),
            mutableListOf<Turno>()
        )
        miPueblo.agregarEspecialidad(pediatria)
        miPueblo.agregarEspecialidad(traumatologia)
        miPueblo.agregarEspecialidad(urologia)
        service.crear(miPueblo)

        var turnoMiPueblo1 = Turno("15/12/2022     16:00 hs", urologia, "Hector Lavagna", miPueblo)
        var turnoMiPueblo2 = Turno("16/12/2022     16:00 hs", urologia, "Hector Lavagna", miPueblo)
        var turnoMiPueblo3 = Turno("23/12/2022     08:00 hs", traumatologia, "Maria Castro", miPueblo)
        var turnoMiPueblo4 = Turno("23/12/2022     08:30 hs", traumatologia, "Maria Castro", miPueblo)
        var turnoMiPueblo5 = Turno("23/12/2022     09:00 hs", traumatologia, "Maria Castro", miPueblo)
        var turnoMiPueblo6 = Turno("04/01/2023     10:00 hs", pediatria, "Patricia Marin", miPueblo)
        var turnoMiPueblo7 = Turno("04/01/2023     10:30 hs", pediatria, "Patricia Marin", miPueblo)
        var turnoMiPueblo8 = Turno("04/01/2023     11:00 hs", pediatria, "Patricia Marin", miPueblo)

        miPueblo.agregarTurno(turnoMiPueblo1)
        miPueblo.agregarTurno(turnoMiPueblo2)
        miPueblo.agregarTurno(turnoMiPueblo3)
        miPueblo.agregarTurno(turnoMiPueblo4)
        miPueblo.agregarTurno(turnoMiPueblo5)
        miPueblo.agregarTurno(turnoMiPueblo6)
        miPueblo.agregarTurno(turnoMiPueblo7)
        miPueblo.agregarTurno(turnoMiPueblo8)

        service.actualizar(miPueblo)


        interzonal = Hospital(
            "Hospital Interzonal de Agudos Evita",
            "Lanus",
            "Diego Armando Maradona 1910",
            mutableListOf<Especialidad>(),
            mutableListOf<Turno>()
        )
        interzonal.agregarEspecialidad(kinesiologia)
        interzonal.agregarEspecialidad(traumatologia)
        interzonal.agregarEspecialidad(cardiologia)
        interzonal.agregarEspecialidad(pediatria)
        interzonal.agregarEspecialidad(dermatologia)
        service.crear(elCruce)

        var turnoInterzonal1 = Turno("15/12/2022     16:00 hs", kinesiologia, "Marina Vista", interzonal)
        var turnoInterzonal2 = Turno("16/12/2022     16:00 hs", kinesiologia, "Marina Vista", interzonal)
        var turnoInterzonal3 = Turno("23/12/2022     08:00 hs", traumatologia, "Natalia Guido", interzonal)
        var turnoInterzonal4 = Turno("23/12/2022     08:30 hs", traumatologia, "Natalia Guido", interzonal)
        var turnoInterzonal5 = Turno("23/12/2022     09:00 hs", traumatologia, "Natalia Guido", interzonal)
        var turnoInterzonal6 = Turno("03/01/2023     10:00 hs", cardiologia, "Pedro Pascal", interzonal)
        var turnoInterzonal7 = Turno("03/01/2023     10:30 hs", cardiologia, "Pedro Pascal", interzonal)
        var turnoInterzonal8 = Turno("03/01/2023     11:00 hs", cardiologia, "Pedro Pascal", interzonal)
        var turnoInterzonal9 = Turno("08/01/2023     09:30 hs", dermatologia, "Hugo del Carril", interzonal)
        var turnoInterzonal10 = Turno("08/01/2023     10:00 hs", dermatologia, "Hugo del Carril", interzonal)

        interzonal.agregarTurno(turnoInterzonal1)
        interzonal.agregarTurno(turnoInterzonal2)
        interzonal.agregarTurno(turnoInterzonal3)
        interzonal.agregarTurno(turnoInterzonal4)
        interzonal.agregarTurno(turnoInterzonal5)
        interzonal.agregarTurno(turnoInterzonal6)
        interzonal.agregarTurno(turnoInterzonal7)
        interzonal.agregarTurno(turnoInterzonal8)
        interzonal.agregarTurno(turnoInterzonal9)
        interzonal.agregarTurno(turnoInterzonal10)

        service.actualizar(interzonal)


        garrahan = Hospital(
            "Hospital Garrahan",
            "CABA",
            "Pichincha 1890",
            mutableListOf<Especialidad>(),
            mutableListOf<Turno>()
        )
        garrahan.agregarEspecialidad(dermatologia)
        garrahan.agregarEspecialidad(oncologia)
        garrahan.agregarEspecialidad(traumatologia)
        garrahan.agregarEspecialidad(cardiologia)
        service.crear(garrahan)

        var turnoGarrahan1 = Turno("26/12/2022     16:00 hs", oncologia, "Isabel Conte", garrahan)
        var turnoGarrahan2 = Turno("26/12/2022     16:30 hs", oncologia, "Isabel Conte", garrahan)
        var turnoGarrahan3 = Turno("26/12/2022     17:00 hs", oncologia, "Isabel Conte", garrahan)
        var turnoGarrahan4 = Turno("23/12/2022     08:30 hs", traumatologia, "Franco Martinez", garrahan)
        var turnoGarrahan5 = Turno("23/12/2022     09:00 hs", traumatologia, "Franco Martinez", garrahan)
        var turnoGarrahan6 = Turno("04/01/2023     10:00 hs", cardiologia, "Maria Belen Cabalieri", garrahan)
        var turnoGarrahan7 = Turno("04/01/2023     10:30 hs", cardiologia, "Maria Belen Cabalieri", garrahan)
        var turnoGarrahan8 = Turno("04/01/2023     11:00 hs", cardiologia, "Maria Belen Cabalieri", garrahan)
        var turnoGarrahan9 = Turno("08/01/2023     09:30 hs", dermatologia, "Joaquin Leal", garrahan)
        var turnoGarrahan10 = Turno("08/01/2023     10:00 hs", dermatologia, "Joaquin Leal", garrahan)

        garrahan.agregarTurno(turnoGarrahan1)
        garrahan.agregarTurno(turnoGarrahan2)
        garrahan.agregarTurno(turnoGarrahan3)
        garrahan.agregarTurno(turnoGarrahan4)
        garrahan.agregarTurno(turnoGarrahan5)
        garrahan.agregarTurno(turnoGarrahan6)
        garrahan.agregarTurno(turnoGarrahan7)
        garrahan.agregarTurno(turnoGarrahan8)
        garrahan.agregarTurno(turnoGarrahan9)
        garrahan.agregarTurno(turnoGarrahan10)

        service.actualizar(garrahan)


        italianoCABA = Hospital(
            "Hospital Italiano de Buenos Aires",
            "CABA",
            "Av. Juan Bautista Alberdi 439",
            mutableListOf<Especialidad>(),
            mutableListOf<Turno>()
        )
        italianoCABA.agregarEspecialidad(pediatria)
        italianoCABA.agregarEspecialidad(traumatologia)
        italianoCABA.agregarEspecialidad(urologia)
        service.crear(italianoCABA)

        var turnoItalianoCABA1 = Turno("26/12/2022     16:00 hs", urologia, "Lucas Gomez", italianoCABA)
        var turnoItalianoCABA2 = Turno("26/12/2022     16:30 hs", urologia, "Lucas Gomez", italianoCABA)
        var turnoItalianoCABA3 = Turno("26/12/2022     17:00 hs", urologia, "Lucas Gomez", italianoCABA)
        var turnoItalianoCABA4 = Turno("23/12/2022     08:30 hs", traumatologia, "Fernanda Davila", italianoCABA)
        var turnoItalianoCABA5 = Turno("23/12/2022     09:00 hs", traumatologia, "Fernanda Davila", italianoCABA)
        var turnoItalianoCABA6 = Turno("04/01/2023     10:00 hs", pediatria, "Hernan Iurisevich", italianoCABA)
        var turnoItalianoCABA7 = Turno("04/01/2023     10:30 hs", pediatria, "Hernan Iurisevich", italianoCABA)

        italianoCABA.agregarTurno(turnoItalianoCABA1)
        italianoCABA.agregarTurno(turnoItalianoCABA2)
        italianoCABA.agregarTurno(turnoItalianoCABA3)
        italianoCABA.agregarTurno(turnoItalianoCABA4)
        italianoCABA.agregarTurno(turnoItalianoCABA5)
        italianoCABA.agregarTurno(turnoItalianoCABA6)
        italianoCABA.agregarTurno(turnoItalianoCABA7)

        service.actualizar(italianoCABA)


        pirovano = Hospital(
            "Hospital Pirovano",
            "CABA",
            "Av. Monroe 3555",
            mutableListOf<Especialidad>(),
            mutableListOf<Turno>()
        )
        pirovano.agregarEspecialidad(pediatria)
        pirovano.agregarEspecialidad(traumatologia)
        pirovano.agregarEspecialidad(urologia)
        pirovano.agregarEspecialidad(oncologia)
        pirovano.agregarEspecialidad(dermatologia)
        pirovano.agregarEspecialidad(reumatologia)
        service.crear(elCruce)

        var turnoPirovano1 = Turno("26/12/2022     16:00 hs", oncologia, "Candela Bercovich", pirovano)
        var turnoPirovano2 = Turno("26/12/2022     16:30 hs", oncologia, "Candela Bercovich", pirovano)
        var turnoPirovano3 = Turno("26/12/2022     17:00 hs", oncologia, "Candela Bercovich", pirovano)
        var turnoPirovano4 = Turno("23/12/2022     08:30 hs", traumatologia, "Claudia Peruggino", pirovano)
        var turnoPirovano5 = Turno("23/12/2022     09:00 hs", traumatologia, "Claudia Peruggino", pirovano)
        var turnoPirovano6 = Turno("04/01/2023     10:00 hs", reumatologia, "Diego Taibo", pirovano)
        var turnoPirovano7 = Turno("04/01/2023     10:30 hs", reumatologia, "Diego Taibo", pirovano)
        var turnoPirovano8 = Turno("04/01/2023     11:00 hs", reumatologia, "Diego Taibo", pirovano)

        pirovano.agregarTurno(turnoPirovano1)
        pirovano.agregarTurno(turnoPirovano2)
        pirovano.agregarTurno(turnoPirovano3)
        pirovano.agregarTurno(turnoPirovano4)
        pirovano.agregarTurno(turnoPirovano5)
        pirovano.agregarTurno(turnoPirovano6)
        pirovano.agregarTurno(turnoPirovano7)
        pirovano.agregarTurno(turnoPirovano8)

        service.actualizar(pirovano)


        sanMartin = Hospital(
            "Hospital San Martin",
            "La Plata",
            "Calle 1 y 70,1900",
            mutableListOf<Especialidad>(),
            mutableListOf<Turno>()
        )
        sanMartin.agregarEspecialidad(dermatologia)
        sanMartin.agregarEspecialidad(cardiologia)
        sanMartin.agregarEspecialidad(traumatologia)
        sanMartin.agregarEspecialidad(pediatria)
        service.crear(sanMartin)

        var turnoSanMartin1 = Turno("15/12/2022     16:00 hs", dermatologia, "Federico Luna", sanMartin)
        var turnoSanMartin2 = Turno("16/12/2022     16:00 hs", dermatologia, "Federico Luna", sanMartin)
        var turnoSanMartin3 = Turno("23/12/2022     08:00 hs", traumatologia, "Maria Cosnard", sanMartin)
        var turnoSanMartin4 = Turno("23/12/2022     08:30 hs", traumatologia, "Maria Cosnard", sanMartin)
        var turnoSanMartin5 = Turno("23/12/2022     09:00 hs", traumatologia, "Maria Cosnard", sanMartin)
        var turnoSanMartin6 = Turno("04/01/2023     10:00 hs", pediatria, "Quimey Ramos", sanMartin)
        var turnoSanMartin7 = Turno("04/01/2023     10:30 hs", pediatria, "Quimey Ramos", sanMartin)
        var turnoSanMartin8 = Turno("03/01/2023     13:00 hs", cardiologia, "Julio Avendaño", sanMartin)

        sanMartin.agregarTurno(turnoSanMartin1)
        sanMartin.agregarTurno(turnoSanMartin2)
        sanMartin.agregarTurno(turnoSanMartin3)
        sanMartin.agregarTurno(turnoSanMartin4)
        sanMartin.agregarTurno(turnoSanMartin5)
        sanMartin.agregarTurno(turnoSanMartin6)
        sanMartin.agregarTurno(turnoSanMartin7)
        sanMartin.agregarTurno(turnoSanMartin8)

        service.actualizar(sanMartin)


        sanRoque = Hospital(
            "Hospital San Roque",
            "La Plata",
            "Calle 508, 1897, Gonnet",
            mutableListOf<Especialidad>(),
            mutableListOf<Turno>()
        )
        sanRoque.agregarEspecialidad(pediatria)
        sanRoque.agregarEspecialidad(traumatologia)
        sanRoque.agregarEspecialidad(kinesiologia)
        service.crear(sanRoque)

        var turnoSanRoque1 = Turno("26/12/2022     16:00 hs", pediatria, "Alejandro Mamani", sanRoque)
        var turnoSanRoque2 = Turno("26/12/2022     16:30 hs", pediatria, "Alejandro Mamani", sanRoque)
        var turnoSanRoque3 = Turno("23/12/2022     14:00 hs", traumatologia, "Diana Sacayan", sanRoque)
        var turnoSanRoque4 = Turno("23/12/2022     14:30 hs", traumatologia, "Diana Sacayan", sanRoque)
        var turnoSanRoque5 = Turno("23/12/2022     15:00 hs", traumatologia, "Diana Sacayan", sanRoque)
        var turnoSanRoque6 = Turno("04/01/2023     10:00 hs", kinesiologia, "Victor Kesler", sanRoque)
        var turnoSanRoque7 = Turno("04/01/2023     10:30 hs", kinesiologia, "Victor Kesler", sanRoque)

        sanRoque.agregarTurno(turnoSanRoque1)
        sanRoque.agregarTurno(turnoSanRoque2)
        sanRoque.agregarTurno(turnoSanRoque3)
        sanRoque.agregarTurno(turnoSanRoque4)
        sanRoque.agregarTurno(turnoSanRoque5)
        sanRoque.agregarTurno(turnoSanRoque6)
        sanRoque.agregarTurno(turnoSanRoque7)

        service.actualizar(sanRoque)


        santamarina = Hospital(
            "Hospital Municipal Santa Marina",
            "Esteban Echeverria",
            "Gral. Alvear 350, Monte Grande",
            mutableListOf<Especialidad>(),
            mutableListOf<Turno>()
        )
        santamarina.agregarEspecialidad(pediatria)
        santamarina.agregarEspecialidad(oncologia)
        santamarina.agregarEspecialidad(dermatologia)
        santamarina.agregarEspecialidad(reumatologia)
        service.crear(santamarina)

        var turnoSantamarina1 = Turno("15/12/2022     16:00 hs", dermatologia, "Julieta Federici", santamarina)
        var turnoSantamarina2 = Turno("15/12/2022     16:30 hs", dermatologia, "Julieta Federici", santamarina)
        var turnoSantamarina3 = Turno("23/12/2022     08:00 hs", reumatologia, "Hilda Gomez", santamarina)
        var turnoSantamarina4 = Turno("23/12/2022     08:30 hs", reumatologia, "Hilda Gomez", santamarina)
        var turnoSantamarina5 = Turno("23/12/2022     09:00 hs", reumatologia, "Hilda Gomez", santamarina)
        var turnoSantamarina6 = Turno("04/01/2023     10:00 hs", pediatria, "Lohana Berkins", santamarina)
        var turnoSantamarina7 = Turno("04/01/2023     10:30 hs", pediatria, "Lohana Berkins", santamarina)
        var turnoSantamarina8 = Turno("07/01/2023     15:00 hs", oncologia, "Tomas Salcedo", santamarina)
        var turnoSantamarina9 = Turno("07/01/2023     15:30 hs", oncologia, "Tomas Salcedo", santamarina)
        var turnoSantamarina10 = Turno("07/01/2023     16:00 hs", oncologia, "Tomas Salcedo", santamarina)
        var turnoSantamarina11 = Turno("07/01/2023     16:30 hs", oncologia, "Tomas Salcedo", santamarina)

        santamarina.agregarTurno(turnoSantamarina1)
        santamarina.agregarTurno(turnoSantamarina2)
        santamarina.agregarTurno(turnoSantamarina3)
        santamarina.agregarTurno(turnoSantamarina4)
        santamarina.agregarTurno(turnoSantamarina5)
        santamarina.agregarTurno(turnoSantamarina6)
        santamarina.agregarTurno(turnoSantamarina7)
        santamarina.agregarTurno(turnoSantamarina8)
        santamarina.agregarTurno(turnoSantamarina9)
        santamarina.agregarTurno(turnoSantamarina10)
        santamarina.agregarTurno(turnoSantamarina11)

        service.actualizar(santamarina)


        bocalandro = Hospital(
            "Hospital Dr. Carlos Bocalandro",
            "Tres de Febrero",
            "RP8 Nº9100 Km. 20,5, Loma Hermosa",
            mutableListOf<Especialidad>(),
            mutableListOf<Turno>()
        )
        bocalandro.agregarEspecialidad(dermatologia)
        bocalandro.agregarEspecialidad(urologia)
        bocalandro.agregarEspecialidad(traumatologia)
        bocalandro.agregarEspecialidad(nefrologia)
        service.crear(bocalandro)

        var turnoBocalandro1 = Turno("04/01/2023     17:45 hs", dermatologia, "Tamara Tenenbaum", bocalandro)
        var turnoBocalandro2 = Turno("05/01/2023     17:45 hs", dermatologia, "Tamara Tenenbaum", bocalandro)
        var turnoBocalandro3 = Turno("23/12/2022     08:00 hs", traumatologia, "Yvone de Lucia", bocalandro)
        var turnoBocalandro4 = Turno("23/12/2022     08:30 hs", traumatologia, "Yvone de Lucia", bocalandro)
        var turnoBocalandro5 = Turno("23/12/2022     09:00 hs", traumatologia, "Yvone de Lucia", bocalandro)
        var turnoBocalandro6 = Turno("04/01/2023     10:00 hs", nefrologia, "Joel Villagran", bocalandro)
        var turnoBocalandro7 = Turno("04/01/2023     10:30 hs", nefrologia, "Joel Villagran", bocalandro)

        bocalandro.agregarTurno(turnoBocalandro1)
        bocalandro.agregarTurno(turnoBocalandro2)
        bocalandro.agregarTurno(turnoBocalandro3)
        bocalandro.agregarTurno(turnoBocalandro4)
        bocalandro.agregarTurno(turnoBocalandro5)
        bocalandro.agregarTurno(turnoBocalandro6)
        bocalandro.agregarTurno(turnoBocalandro7)

        service.actualizar(bocalandro)


        italianoLP = Hospital(
            "Hospital Italiano",
            "La Plata",
            "Av. 51",
            mutableListOf<Especialidad>(),
            mutableListOf<Turno>()
        )
        italianoLP.agregarEspecialidad(pediatria)
        italianoLP.agregarEspecialidad(cardiologia)
        italianoLP.agregarEspecialidad(urologia)
        service.crear(italianoLP)

        var turnoItalianoLP1 = Turno("26/12/2022     16:00 hs", urologia, "Osvaldo Yutay", italianoLP)
        var turnoItalianoLP2 = Turno("26/12/2022     16:30 hs", urologia, "Osvaldo Yutay", italianoLP)
        var turnoItalianoLP3 = Turno("26/12/2022     17:00 hs", urologia, "Osvaldo Yutay", italianoLP)
        var turnoItalianoLP4 = Turno("23/12/2022     08:30 hs", cardiologia, "Cristina Sobisch", italianoLP)
        var turnoItalianoLP5 = Turno("23/12/2022     09:00 hs", cardiologia, "Cristina Sobisch", italianoLP)
        var turnoItalianoLP6 = Turno("23/12/2022     10:00 hs", cardiologia, "Cristina Sobisch", italianoLP)
        var turnoItalianoLP7 = Turno("04/01/2023     10:30 hs", pediatria, "Carmen Hernandez", italianoLP)

        italianoLP.agregarTurno(turnoItalianoLP1)
        italianoLP.agregarTurno(turnoItalianoLP2)
        italianoLP.agregarTurno(turnoItalianoLP3)
        italianoLP.agregarTurno(turnoItalianoLP4)
        italianoLP.agregarTurno(turnoItalianoLP5)
        italianoLP.agregarTurno(turnoItalianoLP6)
        italianoLP.agregarTurno(turnoItalianoLP7)

        service.actualizar(italianoLP)


        sanJuan = Hospital(
            "Hospital San Juan de Dios",
            "CABA",
            "Santa Rosa 1355",
            mutableListOf<Especialidad>(),
            mutableListOf<Turno>()
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
            mutableListOf<Especialidad>(),
            mutableListOf<Turno>()
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
            mutableListOf<Especialidad>(),
            mutableListOf<Turno>()
        )
        sanCayetano.agregarEspecialidad(pediatria)
        sanCayetano.agregarEspecialidad(traumatologia)
        sanCayetano.agregarEspecialidad(urologia)
        service.crear(sanCayetano)

        presidentePeron = Hospital(
            "Hospital Presidente Peron",
            "Avellaneda",
            "Antole France 773, Sarandi",
            mutableListOf<Especialidad>(),
            mutableListOf<Turno>()
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
            mutableListOf<Especialidad>(),
            mutableListOf<Turno>()
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
            mutableListOf<Especialidad>(),
            mutableListOf<Turno>()
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
            mutableListOf<Especialidad>(),
            mutableListOf<Turno>()
        )
        joseCPaz.agregarEspecialidad(dermatologia)
        joseCPaz.agregarEspecialidad(urologia)
        joseCPaz.agregarEspecialidad(traumatologia)
        joseCPaz.agregarEspecialidad(nefrologia)
        service.crear(joseCPaz)

        turno = Turno("02/11/2022     17:45 hs", traumatologia, "Leonardo Sanchez", sanRoque)
        turno = Turno("05/12/2022     09:15 hs", pediatria, "Leonardo Sanchez", sanRoque)
        turno = Turno("015/11/2022     13:30 hs", urologia, "Leonardo Sanchez", sanRoque)


        turnoService.crear(turno)
        turnoService.crear(turnoEvita1)
        turnoService.crear(turnoEvita2)
        turnoService.crear(turnoEvita3)

        user2.sacarTurno(turnoEvita1)
        user2.sacarTurno(turnoEvita7)
        user2.sacarTurno(turnoEvita8)
        usuarioService.actualizar(user2)


    }

    @Test
    fun seCreaHospitalTest() {
        /*
        val wilde = Hospital(
            "Hospital Zonal General de Agudos “Dr. E. Wilde”",
            "Quilmes",
            "Baradero 5808",
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