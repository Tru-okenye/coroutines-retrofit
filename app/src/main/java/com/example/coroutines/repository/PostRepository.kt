package com.example.coroutines.repository


import com.example.coroutines.model.Post
import com.example.coroutines.network.RetrofitInstance

class PostRepository {
    suspend fun fetchPosts(): List<Post> = RetrofitInstance.api.getPosts()
    suspend fun fetchPost(id: Int): Post = RetrofitInstance.api.getPost(id)
}
