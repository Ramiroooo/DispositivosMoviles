//AdivinaNúmero

fun main() {
    val numAleatorio = (1..30).random()
    var totalIntentos = 5

    println("Adivina un número del 1 al 30")
    println("Recuerda que tienes $totalIntentos intentos.")

    for (intento in 1..5) {
        print("Intento $intento: ")
        val intentoUsur = readln().toIntOrNull()

        if (intentoUsur == null || intentoUsur !in 1..30) {
            println("Número incorrecto. Debe estar entre 1 y 30.")
            continue
        }

        if (intentoUsur == numAleatorio) {
            println("Muy bien, adivinaste el número.")
            return
        } else if (intentoUsur < numAleatorio) {
            println("El número es mayor.")
        } else {
            println("El número es menor.")
        }

        totalIntentos--
        println("Te quedan $totalIntentos intentos.")
    }

    println("GAME OVER")
    println("El número correcto era $numAleatorio.")
}
