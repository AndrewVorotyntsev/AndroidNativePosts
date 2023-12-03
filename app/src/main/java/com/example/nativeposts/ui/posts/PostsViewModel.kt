package com.example.nativeposts.ui.posts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.nativeposts.NativePostsApp
import com.example.nativeposts.data.PostsRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class PostsViewModel(
  private val postsRepository: PostsRepository
) : ViewModel() {

  var postsUiState: PostsUiState by mutableStateOf(PostsUiState.Loading)
    private set


  init {
    getPosts()
  }

  fun getPosts() {
    viewModelScope.launch {
      postsUiState = PostsUiState.Loading
      postsUiState =
        try {
          PostsUiState.Success(postsRepository.getPosts())
        } catch (e: IOException) {
          PostsUiState.Error
        } catch (e: HttpException) {
          PostsUiState.Error
        }
    }
  }

  companion object {
    val Factory: ViewModelProvider.Factory = viewModelFactory {
      initializer {
        val application = (this[APPLICATION_KEY] as NativePostsApp)
        val postsRepository = application.container.postsRepository
        PostsViewModel(postsRepository = postsRepository)
      }
    }
  }
}