//Piedra, papel o tijera
import kotlin.random.Random

fun main() {

    print("Elija una opción entre piedra, papel o tijera: ")
    val opcionUsur = readln().capitalize()

    val opcion = listOf("Piedra", "Papel", "Tijera")
    val opcionPC = opcion.random()

    println("Usted eligió: $opcionUsur")
    println("La computadora eligió: $opcionPC")

    val result = when {
        opcionUsur == opcionPC -> "Empató"
        (opcionUsur == "Piedra" && opcionPC == "Tijera") ||
                (opcionUsur == "Papel" && opcionPC == "Piedra") ||
                (opcionUsur == "Tijera" && opcionPC == "Papel") -> "Ganó"
        else -> "Perdió"
    }

    println("Resultado: $result")
}
