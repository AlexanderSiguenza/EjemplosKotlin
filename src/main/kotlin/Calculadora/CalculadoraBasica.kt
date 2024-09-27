package Calculadora
import java.sql.DriverManager.println

fun main() {
    println("Calculadora de operaciones básicas")

    var keepRunning = true

    while (keepRunning) {
        println("Ingrese el primer número:")
        val numero1 = readLine()?.toDoubleOrNull()

        println("Ingrese el segundo número:")
        val numero2 = readLine()?.toDoubleOrNull()

        if (numero1 != null && numero2 != null) {
            mostrarMenuOperaciones()
            val opcion = readLine()?.toIntOrNull()

            when (opcion) {
                1 -> realizarOperacion("Suma", numero1, numero2) { a, b -> a + b }
                2 -> realizarOperacion("Resta", numero1, numero2) { a, b -> a - b }
                3 -> realizarOperacion("Multiplicación", numero1, numero2) { a, b -> a * b }
                4 -> realizarOperacion("División", numero1, numero2) { a, b -> a / b }
                5 -> keepRunning = false
                else -> println("Opción inválida.")
            }
        } else {
            println("Por favor, ingrese dos números válidos.")
        }
    }
}

fun mostrarMenuOperaciones() {
    println("Operaciones disponibles:")
    println("1. Suma")
    println("2. Resta")
    println("3. Multiplicación")
    println("4. División")
    println("5. Salir")
    print("Seleccione una operación (1/2/3/4/5): ")
}

fun realizarOperacion(nombreOperacion: String, a: Double, b: Double, operacion: (Double, Double) -> Double) {
    val resultado = operacion(a, b)
    println("$nombreOperacion: $resultado")
}
