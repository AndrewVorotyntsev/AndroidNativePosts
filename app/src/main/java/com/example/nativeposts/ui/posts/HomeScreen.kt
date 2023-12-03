package com.example.nativeposts.ui.posts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
  postsUiState: PostsUiState,
  retryAction: () -> Unit,
  modifier: Modifier
) {
  when (postsUiState) {
    is PostsUiState.Loading -> LoadingScreen(modifier)
    is PostsUiState.Success -> PostsScreen(
      posts = postsUiState.posts,
      modifier = modifier
    )
    is PostsUiState.Error -> ErrorScreen(retryAction = retryAction, modifier)
  }
}