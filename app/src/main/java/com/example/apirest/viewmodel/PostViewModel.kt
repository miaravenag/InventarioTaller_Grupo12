package com.example.apirest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apirest.data.model.Post
import com.example.apirest.repository.PostRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// ViewModel que mantiene el estado de los datos obtenidos
class PostViewModel : ViewModel() {

    private val repository = PostRepository()

    // Flujo mutable que contiene la lista de posts
    private val _postList = MutableStateFlow<List<Post>>(emptyList())

    // Flujo público de solo lectura
    val postList: StateFlow<List<Post>> = _postList

    // Se llama automáticamente al iniciar
    init {
        fetchPosts()
    }

    // Función que obtiene los datos en segundo plano
    private fun fetchPosts() {
        viewModelScope.launch {
            try {
                _postList.value = repository.getPosts()
            } catch (e: Exception) {
                println("Error al obtener datos: ${e.localizedMessage}")
            }
        }
    }

    // Punto 11: otros métodos HTTP
    fun createPost(post: Post) {
        viewModelScope.launch {
            try {
                val creado = repository.createPost(post)
                _postList.value = listOf(creado) + _postList.value
            } catch (e: Exception) {
                println("Error al crear: ${e.localizedMessage}")
            }
        }
    }

    fun updatePost(post: Post) {
        viewModelScope.launch {
            try {
                val actualizado = repository.updatePost(post)
                _postList.value = _postList.value.map { if (it.id == post.id) actualizado else it }
            } catch (e: Exception) {
                println("Error al actualizar: ${e.localizedMessage}")
            }
        }
    }

    fun deletePost(id: Int) {
        viewModelScope.launch {
            try {
                repository.deletePost(id)
                _postList.value = _postList.value.filter { it.id != id }
            } catch (e: Exception) {
                println("Error al eliminar: ${e.localizedMessage}")
            }
        }
    }
}
