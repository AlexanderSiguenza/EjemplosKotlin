package Calculadora

fun main() {
    println("Ingresa un número para generar la tabla de multiplicar:")
    val numero = readLine()?.toIntOrNull()

    if (numero != null) {
        println("Tabla de multiplicar del $numero:")
        for (i in 1..10) {
            val resultado = numero * i
            println("$numero * $i = $resultado")
        }
    } else {
        println("Entrada inválida. Por favor, ingresa un número válido.")
    }
}
