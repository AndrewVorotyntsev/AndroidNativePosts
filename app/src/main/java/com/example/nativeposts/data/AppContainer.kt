package com.example.nativeposts.data

import com.example.nativeposts.network.PostsService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
  val postsRepository: PostsRepository
}

class DefaultAppContainer : AppContainer {
  private val BASE_URL = "https://jsonplaceholder.typicode.com/"

  private val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

  private val retrofitService: PostsService by lazy {
    retrofit.create(PostsService::class.java)
  }

  override val postsRepository: PostsRepository by lazy {
    NetworkPostsRepository(retrofitService)
  }
}