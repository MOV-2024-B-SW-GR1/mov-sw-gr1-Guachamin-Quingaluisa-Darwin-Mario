package com.example.veterinariaapp.models

data class Veterinario(
    val id: Int,
    val nombre: String,
    val mascotas: MutableList<Mascota>
)
