package ar.edu.unq.turnero

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class TurneroApp

fun main(args: Array<String>) {
    runApplication<TurneroApp>(*args)
}