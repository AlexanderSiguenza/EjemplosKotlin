package Productos

import java.io.File

class GestionProductos(private val archivo: File) {
    private val productos = mutableListOf<Producto>()

    init {
        cargarProductosDesdeArchivo()
    }

    private fun cargarProductosDesdeArchivo() {
        if (archivo.exists()) {
            archivo.forEachLine { linea ->
                val partes = linea.split(",")
                if (partes.size == 4) {
                    val id = partes[0].toInt()
                    val nombre = partes[1]
                    val unidad = partes[2]
                    val precio = partes[3]
                    productos.add(Producto(id, nombre, unidad, precio))
                }
            }
        }
    }

    private fun guardarProductosEnArchivo() {
        archivo.bufferedWriter().use { writer ->
            productos.forEach { producto ->
                writer.write("${producto.id},${producto.nombre},${producto.unidad},${producto.precio}\n")
            }
        }
    }

    fun agregarProducto(id: Int, nombre: String, unidad: String, precio: String) {
        val nuevoProducto = Producto(id, nombre, unidad, precio)
        productos.add(nuevoProducto)
        guardarProductosEnArchivo()
    }

    fun listarProductos() {
        if (productos.isEmpty()) {
            println("No hay productos registrados.")
        } else {
            println("ID,Nombre,Unidad,Precio")
            for (producto in productos) {
                println("${producto.id},${producto.nombre},${producto.unidad},${producto.precio}")
            }
        }
    }
}
