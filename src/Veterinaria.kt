data class Veterinaria(
    val id: Int,
    var nombre: String,
    var direccion: String,
    var telefono: String,
    val citas: MutableList<Cita> = mutableListOf()
)
