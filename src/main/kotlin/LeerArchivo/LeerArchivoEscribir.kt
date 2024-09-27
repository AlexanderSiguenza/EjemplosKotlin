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

        escribirArchivoOrdenado(lineas)
    } else {
        println("El archivo está vacío.")
    }
}

// Las funciones LeerArchivo.leerArchivo, LeerArchivo.imprimirElementos y leerArchivoOrdenado se mantienen igual como se mencionó anteriormente.

fun escribirArchivoOrdenado(registros: List<String>) {
    val registrosOrdenados = registros.sortedByDescending { it.split(",")[2].toDouble() }

    val nombreArchivoOrdenado = "D:\\datos_ordenados.txt"
    try {
        File(nombreArchivoOrdenado).printWriter().use { writer ->
            for (registro in registrosOrdenados) {
                val elementos = registro.split(",")
                val registroOrdenado = elementos.joinToString("|")
                writer.println(registroOrdenado)
            }
        }
        println("Registros ordenados escritos en $nombreArchivoOrdenado")
    } catch (e: Exception) {
        println("Error al escribir el archivo ordenado: ${e.message}")
    }
}
