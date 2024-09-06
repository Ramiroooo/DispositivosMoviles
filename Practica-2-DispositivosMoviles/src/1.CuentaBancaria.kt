//Diseña una clase CuentaBancaria que tenga un saldo y un límite de retiro.
//Ramiro Jesus Canqui Llamosas
//05/09/2024
//06/09/2024
class CuentaBancaria(
    saldoInicial: Double,
    limiteRetiroInicial: Double
) {
    var saldo: Double = saldoInicial
        get() {
            return field
        }
        set(value) {
            require(value >= 0) { "El saldo no puede ser negativo." }
            field = value
        }

    var limiteRetiro: Double = limiteRetiroInicial
        get() {
            return field
        }
        set(value) {
            require(value > 0) { "El límite de retiro debe ser mayor que 0." }
            field = value
        }

    // Método para realizar retiros
    fun retirar(monto: Double) {
        require(monto > 0) { "El monto a retirar debe ser positivo." }
        require(monto <= limiteRetiro) { "El monto excede el límite de retiro de $$limiteRetiro." }
        require(monto <= saldo) { "No tienes suficiente saldo para retirar $$monto." }

        saldo -= monto
        println("Has retirado $$monto. Tu nuevo saldo es $$saldo.")
    }
}

fun main() {
    val cuenta = CuentaBancaria(1000.0, 500.0)

    println("Saldo actual: ${cuenta.saldo}")
    println("Límite de retiro actual: ${cuenta.limiteRetiro}")

    cuenta.retirar(200.0) // Retiro exitoso
    cuenta.saldo = 800.0  // Usando el setter explícito para modificar el saldo
    cuenta.limiteRetiro = 300.0  // Usando el setter para modificar el límite de retiro

    println("Nuevo saldo: ${cuenta.saldo}")
    println("Nuevo límite de retiro: ${cuenta.limiteRetiro}")
}