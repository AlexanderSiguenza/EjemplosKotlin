package LeerArchivo

import java.io.File

fun main() {
    val archivo = "D:\\datos.txt"

    val lineas = leerArchivo(archivo)
    if (lineas.isNotEmpty()) {
        for (linea in lineas) {
            val elementos = linea.split(",")
            if (elementos.size == 4) {
                imprimirElementos(elementos)
            } else {
                println("Error: Formato de línea incorrecto")
            }
        }
    } else {
        println("El archivo está vacío.")
    }
}

fun leerArchivo(nombreArchivo: String): List<String> {
    val lineas = mutableListOf<String>()
    try {
        File(nombreArchivo).useLines { lineas.addAll(it) }
    } catch (e: Exception) {
        println("Error al leer el archivo: ${e.message}")
    }
    return lineas
}

fun imprimirElementos(elementos: List<String>) {
    val id = elementos[0]
    val descripcion = elementos[1]
    val precio = elementos[2]
    val fecha = elementos[3]

    println("ID: $id, Descripción: $descripcion, Precio: $precio, Fecha: $fecha")
}
