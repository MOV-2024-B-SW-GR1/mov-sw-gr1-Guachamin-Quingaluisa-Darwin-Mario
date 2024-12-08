import java.io.File

fun main() {
    val veterinarias = cargarVeterinariasDesdeArchivo("veterinarias.txt")

    while (true) {
        println("\n--- MENÚ CRUD ---")
        println("1. Crear Veterinaria")
        println("2. Leer Veterinarias")
        println("3. Actualizar Veterinaria")
        println("4. Eliminar Veterinaria")
        println("5. Crear Cita")
        println("6. Leer Citas")
        println("7. Actualizar Cita")
        println("8. Eliminar Cita")
        println("9. Salir")
        print("Seleccione una opción: ")

        when (readLine()?.toIntOrNull()) {
            1 -> crearVeterinaria(veterinarias)
            2 -> leerVeterinarias(veterinarias)
            3 -> actualizarVeterinaria(veterinarias)
            4 -> eliminarVeterinaria(veterinarias)
            5 -> crearCita(veterinarias)
            6 -> leerCitas(veterinarias)
            7 -> actualizarCita(veterinarias)
            8 -> eliminarCita(veterinarias)
            9 -> {
                guardarVeterinariasEnArchivo(veterinarias, "veterinarias.txt")
                println("¡Datos guardados! Saliendo del sistema...")
                break
            }
            else -> println("Opción inválida. Intente de nuevo.")
        }
    }
}

fun crearVeterinaria(veterinarias: MutableList<Veterinaria>) {
    println("Ingrese el ID de la veterinaria:")
    val id = readLine()!!.toInt()
    println("Ingrese el nombre de la veterinaria:")
    val nombre = readLine()!!
    println("Ingrese la dirección de la veterinaria:")
    val direccion = readLine()!!
    println("Ingrese el teléfono de la veterinaria:")
    val telefono = readLine()!!
    veterinarias.add(Veterinaria(id, nombre, direccion, telefono))
    println("¡Veterinaria creada exitosamente!")
}

fun leerVeterinarias(veterinarias: MutableList<Veterinaria>) {
    if (veterinarias.isEmpty()) {
        println("No hay veterinarias registradas.")
    } else {
        veterinarias.forEach {
            println("ID: ${it.id}, Nombre: ${it.nombre}, Dirección: ${it.direccion}, Teléfono: ${it.telefono}, Citas: ${it.citas.size}")
        }
    }
}

fun actualizarVeterinaria(veterinarias: MutableList<Veterinaria>) {
    println("Ingrese el ID de la veterinaria que desea actualizar:")
    val id = readLine()!!.toInt()
    val veterinaria = veterinarias.find { it.id == id }
    if (veterinaria != null) {
        println("Ingrese el nuevo nombre (deje en blanco para no cambiar):")
        val nuevoNombre = readLine()!!
        println("Ingrese la nueva dirección (deje en blanco para no cambiar):")
        val nuevaDireccion = readLine()!!
        println("Ingrese el nuevo teléfono (deje en blanco para no cambiar):")
        val nuevoTelefono = readLine()!!

        if (nuevoNombre.isNotBlank()) veterinaria.nombre = nuevoNombre
        if (nuevaDireccion.isNotBlank()) veterinaria.direccion = nuevaDireccion
        if (nuevoTelefono.isNotBlank()) veterinaria.telefono = nuevoTelefono

        println("¡Veterinaria actualizada exitosamente!")
    } else {
        println("No se encontró una veterinaria con ese ID.")
    }
}

fun eliminarVeterinaria(veterinarias: MutableList<Veterinaria>) {
    println("Ingrese el ID de la veterinaria que desea eliminar:")
    val id = readLine()!!.toInt()
    if (veterinarias.removeIf { it.id == id }) {
        println("¡Veterinaria eliminada exitosamente!")
    } else {
        println("No se encontró una veterinaria con ese ID.")
    }
}

fun crearCita(veterinarias: MutableList<Veterinaria>) {
    leerVeterinarias(veterinarias)
    println("Ingrese el ID de la veterinaria donde desea agregar la cita:")
    val idVeterinaria = readLine()!!.toInt()
    val veterinaria = veterinarias.find { it.id == idVeterinaria }
    if (veterinaria != null) {
        println("Ingrese el ID de la cita:")
        val id = readLine()!!.toInt()
        println("Ingrese la fecha de la cita:")
        val fecha = readLine()!!
        println("Ingrese el motivo de la cita:")
        val motivo = readLine()!!
        println("Ingrese la duración de la cita (en horas):")
        val duracion = readLine()!!.toDouble()
        println("Ingrese el costo de la cita:")
        val costo = readLine()!!.toDouble()
        println("¿La cita se realizó? (true/false):")
        val realizada = readLine()!!.toBoolean()
        veterinaria.citas.add(Cita(id, fecha, motivo, duracion, costo, realizada))
        println("¡Cita creada exitosamente!")
    } else {
        println("No se encontró una veterinaria con ese ID.")
    }
}

fun leerCitas(veterinarias: MutableList<Veterinaria>) {
    leerVeterinarias(veterinarias)
    println("Ingrese el ID de la veterinaria para ver sus citas:")
    val idVeterinaria = readLine()!!.toInt()
    val veterinaria = veterinarias.find { it.id == idVeterinaria }
    if (veterinaria != null) {
        if (veterinaria.citas.isEmpty()) {
            println("No hay citas registradas para esta veterinaria.")
        } else {
            veterinaria.citas.forEach {
                println("ID: ${it.id}, Fecha: ${it.fecha}, Motivo: ${it.motivo}, Duración: ${it.duracion}, Costo: ${it.costo}, Realizada: ${it.realizada}")
            }
        }
    } else {
        println("No se encontró una veterinaria con ese ID.")
    }
}

fun actualizarCita(veterinarias: MutableList<Veterinaria>) {
    leerVeterinarias(veterinarias)
    println("Ingrese el ID de la veterinaria donde está la cita:")
    val idVeterinaria = readLine()!!.toInt()
    val veterinaria = veterinarias.find { it.id == idVeterinaria }
    if (veterinaria != null) {
        println("Ingrese el ID de la cita que desea actualizar:")
        val idCita = readLine()!!.toInt()
        val cita = veterinaria.citas.find { it.id == idCita }
        if (cita != null) {
            println("Ingrese la nueva fecha (deje en blanco para no cambiar):")
            val nuevaFecha = readLine()!!
            println("Ingrese el nuevo motivo (deje en blanco para no cambiar):")
            val nuevoMotivo = readLine()!!
            println("Ingrese la nueva duración (deje en blanco para no cambiar):")
            val nuevaDuracion = readLine()!!.toDoubleOrNull()
            println("Ingrese el nuevo costo (deje en blanco para no cambiar):")
            val nuevoCosto = readLine()!!.toDoubleOrNull()
            println("¿La cita se realizó? (true/false, deje en blanco para no cambiar):")
            val nuevaRealizada = readLine()!!.toBooleanStrictOrNull()

            if (nuevaFecha.isNotBlank()) cita.fecha = nuevaFecha
            if (nuevoMotivo.isNotBlank()) cita.motivo = nuevoMotivo
            if (nuevaDuracion != null) cita.duracion = nuevaDuracion
            if (nuevoCosto != null) cita.costo = nuevoCosto
            if (nuevaRealizada != null) cita.realizada = nuevaRealizada

            println("¡Cita actualizada exitosamente!")
        } else {
            println("No se encontró una cita con ese ID.")
        }
    } else {
        println("No se encontró una veterinaria con ese ID.")
    }
}

fun eliminarCita(veterinarias: MutableList<Veterinaria>) {
    leerVeterinarias(veterinarias)
    println("Ingrese el ID de la veterinaria donde está la cita:")
    val idVeterinaria = readLine()!!.toInt()
    val veterinaria = veterinarias.find { it.id == idVeterinaria }
    if (veterinaria != null) {
        println("Ingrese el ID de la cita que desea eliminar:")
        val idCita = readLine()!!.toInt()
        if (veterinaria.citas.removeIf { it.id == idCita }) {
            println("¡Cita eliminada exitosamente!")
        } else {
            println("No se encontró una cita con ese ID.")
        }
    } else {
        println("No se encontró una veterinaria con ese ID.")
    }
}

fun guardarVeterinariasEnArchivo(veterinarias: MutableList<Veterinaria>, archivo: String) {
    val file = File(archivo)
    file.printWriter().use { out ->
        veterinarias.forEach { vet ->
            out.println("${vet.id}|${vet.nombre}|${vet.direccion}|${vet.telefono}")
            vet.citas.forEach { cita ->
                out.println("CITA|${cita.id}|${cita.fecha}|${cita.motivo}|${cita.duracion}|${cita.costo}|${cita.realizada}")
            }
        }
    }
}

fun cargarVeterinariasDesdeArchivo(archivo: String): MutableList<Veterinaria> {
    val file = File(archivo)
    if (!file.exists()) return mutableListOf()

    val veterinarias = mutableListOf<Veterinaria>()
    var currentVeterinaria: Veterinaria? = null

    file.forEachLine { line ->
        val parts = line.split("|")

        if (parts.size > 4) { // Es una veterinaria
            val veterinaria = Veterinaria(
                id = parts[0].toInt(),
                nombre = parts[1],
                direccion = parts[2],
                telefono = parts[3]
            )
            veterinarias.add(veterinaria)
            currentVeterinaria = veterinaria
        } else if (parts.size == 6) { // Es una cita
            val cita = Cita(
                id = parts[0].toInt(),
                fecha = parts[1],
                motivo = parts[2],
                duracion = parts[3].toDouble(),
                costo = parts[4].toDouble(),
                realizada = parts[5].toBoolean()
            )
            currentVeterinaria?.citas?.add(cita)
        }
    }

    return veterinarias
}


