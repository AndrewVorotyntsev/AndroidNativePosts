package com.example.nativeposts.network

import com.example.nativeposts.data.PostsResponse
import retrofit2.http.GET

interface PostsService {

  @GET("posts")
  suspend fun fetchPosts(): List<PostsResponse>
}