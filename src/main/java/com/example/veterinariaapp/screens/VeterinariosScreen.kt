package com.example.veterinariaapp.screens
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.veterinariaapp.models.Veterinario
import com.example.veterinariaapp.models.Mascota
import androidx.compose.material.Text



val veterinarios = listOf(
    Veterinario(
        id = 1,
        nombre = "Dr. Juan Pérez",
        mascotas = mutableListOf(
            Mascota(nombre = "Firulais", edad = 5),
            Mascota(nombre = "Pelusa", edad = 2)
        )
    ),
    Veterinario(
        id = 2,
        nombre = "Dra. Ana López",
        mascotas = mutableListOf(
            Mascota(nombre = "Max", edad = 3)
        )
    ),
    Veterinario(
        id = 3,
        nombre = "Dr. Carlos Ruiz",
        mascotas = mutableListOf(
            Mascota(nombre = "Rocky", edad = 4)
        )
    )
)


@Composable
fun VeterinariosScreen() {
    Column(Modifier.padding(16.dp)) {
        Text(
            "Lista de Veterinarios",
            style = TextStyle(fontSize = 18.sp)
        )
        Spacer(Modifier.height(16.dp))

        // Mostrar veterinarios
        veterinarios.forEach { veterinario ->
            Text("Veterinario: ${veterinario.nombre}")
            Text("Mascotas:")
            veterinario.mascotas.forEach { mascota ->
                Text("- ${mascota.nombre}, Edad: ${mascota.edad}")
            }
            Spacer(Modifier.height(16.dp))
        }
    }
}
