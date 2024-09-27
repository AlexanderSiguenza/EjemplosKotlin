package Productos

import Productos.GestionProductos
import java.io.File
import java.util.*

fun main() {
    val archivoProductos = File("D:\\productos.txt")
    val gestionProductos = GestionProductos(archivoProductos)

    val scanner = Scanner(System.`in`)
    var opcion: Int

    do {
        println("Menu:")
        println("1. Agregar Productos.Producto")
        println("2. Listar Productos")
        println("3. Salir")
        print("Ingrese su opción: ")

        opcion = scanner.nextInt()

        when (opcion) {
            1 -> {
                println("Ingrese el ID del producto:")
                val id = scanner.nextInt()
                scanner.nextLine() // Consumir la nueva línea
                println("Ingrese el nombre del producto:")
                val nombre = scanner.nextLine()
                println("Ingrese la unidad del producto:")
                val unidad = scanner.nextLine()
                println("Ingrese el precio del producto:")
                val precio = scanner.nextLine()

                gestionProductos.agregarProducto(id, nombre, unidad, precio)
                println("Productos.Producto agregado con éxito.")
            }
            2 -> {
                gestionProductos.listarProductos()
            }
            3 -> {
                println("Saliendo del programa.")
            }
            else -> {
                println("Opción no válida. Intente de nuevo.")
            }
        }
    } while (opcion != 3)
}