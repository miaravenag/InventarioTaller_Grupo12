package com.example.apirest.repository

import com.example.apirest.data.model.Post
import com.example.apirest.data.remote.RetrofitInstance

// Este repositorio se encarga de acceder a los datos usando Retrofit
class PostRepository {

    // Función que obtiene los posts desde la API
    suspend fun getPosts(): List<Post> {
        return RetrofitInstance.api.getPosts()
    }

    // Punto 11: otros métodos HTTP
    suspend fun createPost(post: Post): Post {
        return RetrofitInstance.api.createPost(post)
    }

    suspend fun updatePost(post: Post): Post {
        return RetrofitInstance.api.updatePost(post.id, post)
    }

    suspend fun deletePost(id: Int) {
        RetrofitInstance.api.deletePost(id)
    }
}
