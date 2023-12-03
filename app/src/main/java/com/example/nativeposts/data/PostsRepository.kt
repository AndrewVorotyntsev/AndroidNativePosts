package com.example.nativeposts.data

import com.example.nativeposts.network.PostsService

interface PostsRepository {
  suspend fun getPosts() : List<Post>
}

class NetworkPostsRepository(
  private val postsService: PostsService
) : PostsRepository {

  override suspend fun getPosts(): List<Post> {
    val postsResponse = postsService.fetchPosts()
    return postsResponse.map { items ->
      Post(
        title = items.title,
        body = items.body
      )
    }
  }
}