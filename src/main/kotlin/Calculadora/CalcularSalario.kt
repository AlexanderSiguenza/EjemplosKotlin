package Calculadora

fun main() {
    println("Ingrese el salario del empleado:")
    val salarioBruto = readLine()?.toDoubleOrNull()

    if (salarioBruto != null) {
        val seguroSocial = calcularSeguroSocial(salarioBruto)
        val impuestoRenta = calcularImpuestoRenta(salarioBruto)

        val salarioNeto = salarioBruto - seguroSocial - impuestoRenta

        println("Deducciones:")
        println("Seguro Social: $seguroSocial")
        println("Impuesto sobre la Renta: $impuestoRenta")
        println("Salario Neto: $salarioNeto")
    } else {
        println("Salario inválido. Ingrese un salario válido.")
    }
}

fun calcularSeguroSocial(salarioBruto: Double): Double {
    // Calcular el seguro social basado en alguna fórmula
    // Puedes ajustar la fórmula según las leyes de tu país
    val porcentajeSeguroSocial = 0.1
    return salarioBruto * porcentajeSeguroSocial
}

fun calcularImpuestoRenta(salarioBruto: Double): Double {
    // Calcular el impuesto sobre la renta basado en alguna fórmula
    // Puedes ajustar la fórmula según las leyes de tu país
    val porcentajeImpuestoRenta = 0.15
    return salarioBruto * porcentajeImpuestoRenta
}
