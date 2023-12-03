package com.example.nativeposts.ui.posts

import com.example.nativeposts.data.Post

sealed interface PostsUiState {
  data class Success(val posts: List<Post>) : PostsUiState
  object Error : PostsUiState
  object Loading : PostsUiState
}
