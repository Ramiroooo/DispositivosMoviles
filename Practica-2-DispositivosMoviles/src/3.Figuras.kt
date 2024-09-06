//Cree una clase abstracta “shape” la cual contenga las propiedades área, perímetro y las funciones para calcular estos valores e imprimir el resultado de cada operación
//Ramiro Jesus Canqui Llamosas
//05/09/2024
//06/09/2024
abstract class Shape {
    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double

    fun imprimirResultados() {
        println("Área: ${calcularArea()}")
        println("Perímetro: ${calcularPerimetro()}")
    }
}

// Subclase Cuadrado
class Cuadrado(private val lado: Double) : Shape() {
    override fun calcularArea(): Double {
        return lado * lado
    }

    override fun calcularPerimetro(): Double {
        return 4 * lado
    }
}

// Subclase Círculo
class Circulo(private val radio: Double) : Shape() {
    override fun calcularArea(): Double {
        return Math.PI * radio * radio
    }

    override fun calcularPerimetro(): Double {
        return 2 * Math.PI * radio
    }
}

// Subclase Rectángulo
class Rectangulo(private val largo: Double, private val ancho: Double) : Shape() {
    override fun calcularArea(): Double {
        return largo * ancho
    }

    override fun calcularPerimetro(): Double {
        return 2 * (largo + ancho)
    }
}

// Función principal para probar las clases
fun main() {
    val cuadrado = Cuadrado(4.0)
    println("Cuadrado:")
    cuadrado.imprimirResultados()

    val circulo = Circulo(3.0)
    println("\nCírculo:")
    circulo.imprimirResultados()

    val rectangulo = Rectangulo(5.0, 3.0)
    println("\nRectángulo:")
    rectangulo.imprimirResultados()
}