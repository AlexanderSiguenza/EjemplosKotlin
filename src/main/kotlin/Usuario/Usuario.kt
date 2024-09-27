package Usuario

import java.io.File

data class Usuario(val nombreUsuario: String, val contrasena: String)

fun main() {
    val usuarios = mutableListOf<Usuario>()
    val archivoUsuarios = File("D:\\usuarios.txt")

    if (archivoUsuarios.exists()) {
        cargarUsuariosDesdeArchivo(usuarios, archivoUsuarios)
    }

    var opcion: Int
    do {
        println("1. Registrarse")
        println("2. Iniciar Sesión")
        println("3. Mostrar Todos los Usuarios")
        println("4. Salir")
        print("Ingrese su opción: ")
        opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> registrarUsuario(usuarios, archivoUsuarios)
            2 -> iniciarSesion(usuarios)
            3 -> mostrarTodosLosUsuarios(usuarios)
            4 -> println("Saliendo del programa.")
            else -> println("Opción no válida. Intente de nuevo.")
        }
    } while (opcion != 4)
}

fun cargarUsuariosDesdeArchivo(usuarios: MutableList<Usuario>, archivo: File) {
    archivo.forEachLine { linea ->
        val partes = linea.split(",")
        if (partes.size == 2) {
            val nombreUsuario = partes[0]
            val contrasena = partes[1]
            usuarios.add(Usuario(nombreUsuario, contrasena))
        }
    }
}

fun guardarUsuariosEnArchivo(usuarios: List<Usuario>, archivo: File) {
    archivo.bufferedWriter().use { writer ->
        usuarios.forEach { usuario ->
            writer.write("${usuario.nombreUsuario},${usuario.contrasena}\n")
        }
    }
}

fun registrarUsuario(usuarios: MutableList<Usuario>, archivo: File) {
    print("Ingrese nombre de usuario: ")
    val nombreUsuario = readLine()
    print("Ingrese contraseña: ")
    val contrasena = readLine()

    if (nombreUsuario != null && contrasena != null) {
        val nuevoUsuario = Usuario(nombreUsuario, contrasena)
        usuarios.add(nuevoUsuario)
        guardarUsuariosEnArchivo(usuarios, archivo)
        println("Usuario.Usuario registrado con éxito.")
    } else {
        println("Error al registrar el usuario.")
    }
}

fun iniciarSesion(usuarios: List<Usuario>) {
    print("Ingrese nombre de usuario: ")
    val nombreUsuario = readLine()
    print("Ingrese contraseña: ")
    val contrasena = readLine()

    val usuario = usuarios.find { it.nombreUsuario == nombreUsuario && it.contrasena == contrasena }

    if (usuario != null) {
        println("Inicio de sesión exitoso.")
    } else {
        println("Nombre de usuario o contraseña incorrectos.")
    }
}

fun mostrarTodosLosUsuarios(usuarios: List<Usuario>) {
    println("Usuarios registrados:")
    for (usuario in usuarios) {
        println("Nombre de usuario: ${usuario.nombreUsuario}")
    }
}

