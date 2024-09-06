//Diseña una clase Producto que tenga un precio y un descuento aplicable.
//Ramiro Jesus Canqui Llamosas
//05/09/2024
//06/09/2024
class Producto(precioInicial: Double, descuentoInicial: Double) {
    var precio: Double = precioInicial
        get() = field
        set(value) {
            require(value >= 0) { "El precio no puede ser negativo." }
            field = value // Actualiza precio
        }

    var descuento: Double = descuentoInicial
        get() = field // Devuelve descuento
        set(value) {
            require(value in 0.0..100.0) { "El descuento debe estar entre 0 y 100." }
            field = value // Actualiza  descuento
        }

    fun calcularPrecioFinal(): Double {
        val precioFinal = precio - (precio * descuento / 100)
        return precioFinal
    }
}

fun main() {
    val producto = Producto(100.0, 20.0)

    println("Precio original: ${producto.precio}")
    println("Descuento: ${producto.descuento}%")

    println("Precio final después del descuento: ${producto.calcularPrecioFinal()}")

    producto.precio = 200.0
    producto.descuento = 10.0

    println("\nNuevo precio: ${producto.precio}")
    println("Nuevo descuento: ${producto.descuento}%")
    println("Nuevo precio final después del descuento: ${producto.calcularPrecioFinal()}")
}