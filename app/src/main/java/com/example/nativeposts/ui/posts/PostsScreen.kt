package com.example.nativeposts.ui.posts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nativeposts.data.Post

@Composable
fun PostsScreen(
  posts: List<Post>,
  modifier: Modifier
) {
  LazyColumn(
    modifier = Modifier.fillMaxSize()) {
    itemsIndexed(posts) { _, post ->
      Column (
        verticalArrangement = Arrangement.Center
      ) {
        Text(
          text = post.title,
          fontSize = 18.sp,
          fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = post.body,
          fontStyle = FontStyle.Italic,
        )
        Spacer(modifier = Modifier.width(6.dp))
        Divider()
      }
    }
  }
}