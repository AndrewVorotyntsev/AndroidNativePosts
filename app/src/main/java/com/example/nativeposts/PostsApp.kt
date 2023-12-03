package com.example.nativeposts

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nativeposts.ui.posts.HomeScreen
import com.example.nativeposts.ui.posts.PostsViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PostsApp(
  modifier: Modifier = Modifier
) {
  val postsViewModel: PostsViewModel =
    viewModel(factory = PostsViewModel.Factory)

  Scaffold(
    modifier = modifier.fillMaxSize(),
    topBar = {
      TopAppBar (
        title = {
          Text("Лента")
        }
      )
    }

  ) {
    Surface(modifier = modifier
      .fillMaxSize()
      .padding(12.dp),
      color = MaterialTheme.colors.background
    ) {
      HomeScreen(
        postsUiState = postsViewModel.postsUiState,
        retryAction = { postsViewModel.getPosts() },
        modifier = modifier
      )
    }
  }
}