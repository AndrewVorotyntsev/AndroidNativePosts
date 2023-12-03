package com.example.nativeposts.data

import com.google.gson.annotations.SerializedName

data class Post(
  var userId: Int? = null,
  var id: Int? = null,
  val title: String = "",
  val body: String = ""
)
