//EvaluaciónEmpleados
fun main() {
    print("Del 0 al 10 ingrese la puntuación del usuario: ")
    val ptje= readln().toDouble()

    print("Ingrese el salario mensual del mismo: ")
    val salario= readln().toDouble()

    val nivel = when (ptje) {
        in 0.0..3.0-> "Inaceptable"
        in 4.0..6.0-> "Aceptable"
        in 7.0..10.0-> "Meritorio"
        else-> "Puntuación no válida"
    }

    val dineroFinal= salario*(ptje/10)

    println("Nivel de Rendimiento: $nivel")
    println("Puntuación del empleado: $ptje")
    println("El dinero recibido es de: $$dineroFinal")
}
