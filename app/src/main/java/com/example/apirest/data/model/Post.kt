package com.example.apirest.data.model

// Representa un post obtenido desde la API
data class Post(
    val userId: Int,    // ID del usuario que creó el post
    val id: Int,        // ID del post
    val title: String,  // Título del post
    val body: String    // Contenido del post
)
