package Inventario

import java.io.File
import java.io.FileReader
import java.io.BufferedReader
import java.io.FileWriter
//import java.sql.DriverManager.println
import java.util.ArrayList


fun main() {
    val archivo = Archivo()

    var opcion = 0
    do {
        println("Menu:")
        println("1. Agregar fila")
        println("2. Actualizar fila")
        println("3. Mostrar Inventario")
        println("4. Salir")

        opcion = readLine()!!.toInt()

        when (opcion) {
            1 -> archivo.agregarFila()
            2 -> archivo.actualizarFila()
            3 -> archivo.mostrarArchivo()
            4 -> println("Saliendo...")
        }
    } while (opcion != 4)
}

class Archivo {

    private val archivo = File("D:\\inventario.txt")
    private val lector = BufferedReader(FileReader(archivo))

    val datos = ArrayList<String>()

    init {
        while (true) {
            val linea = lector.readLine()
            if (linea == null) {
                break
            }

            datos.add(linea)
        }

        lector.close()
    }

    fun agregarFila() {
        println("Ingrese el id del producto:")
        val id = readLine()!!

        println("Ingrese el nombre del producto:")
        val producto = readLine()!!

        println("Ingrese la existencia del producto:")
        val existencia = readLine()!!.toInt()

        datos.add("${id},${producto},${existencia}")

        guardarArchivo()
    }

    fun actualizarFila() {
        println("Ingrese el id del producto que desea actualizar:")
        val id = readLine()!!

        val posicion = datos.indexOfFirst { it.split(",")[0] == id }
        if (posicion == -1) {
            println("No se encontró el producto con el id $id")
            return
        }

        println("Ingrese el nuevo nombre del producto:")
        val producto = readLine()!!

        println("Ingrese la nueva existencia del producto:")
        val existencia = readLine()!!.toInt()

        datos[posicion] = "${id},${producto},${existencia}"

        guardarArchivo()
    }

    fun mostrarArchivo() {
        for (linea in datos) {
            println(linea)
        }
    }

    private fun guardarArchivo() {
        val escritor = FileWriter(archivo)
        for (linea in datos) {
            escritor.write(linea + "\n")
            println(linea)
        }

        escritor.close()
    }
}

