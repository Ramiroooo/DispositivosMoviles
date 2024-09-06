//Calculadora Elemental

fun main() {
    while (true) {
        println("==== Menú ====")
        println("1. Sumar")
        println("2. Restar")
        println("3. Multiplicar")
        println("4. Dividir")
        println("5. Salir")
        print("Elija una opción del 1 al 5: ")

        val opcion = readln().trim().toIntOrNull()

        when (opcion) {
            1, 2, 3, 4 -> {
                val (num1, num2) = numeros()
                val result= when (opcion) {
                    1-> num1 + num2
                    2-> num1 - num2
                    3-> num1 * num2
                    4-> if (num2 != 0.0) num1 / num2 else {
                        println("Error: División por cero.")
                        continue
                    }
                    else -> {
                        println("La opción que ingresó no es válida.")
                        continue
                    }
                }
                println("Resultado: $result")
            }
            5 -> {
                println("Saliendo del programa.")
                return
            }
            else -> println("Opción no válida. Intente de nuevo.")
        }
    }
}

fun numeros(): Pair<Double, Double> {
    while (true) {
        print("Ingrese el primer número: ")
        val num1 = readln().toDoubleOrNull()
        if (num1 != null) {
            print("Ingrese el segundo número: ")
            val num2 = readln().toDoubleOrNull()
            if (num2 != null) {
                return Pair(num1, num2)
            } else {
                println("Número inválido. Intente de nuevo.")
            }
        } else {
            println("Número inválido. Intente de nuevo.")
        }
    }
}
