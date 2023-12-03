package com.example.nativeposts.data

import com.google.gson.annotations.SerializedName


data class PostsResponse (

  @SerializedName("userId" ) var userId : Int?    = null,
  @SerializedName("id"     ) var id     : Int?    = null,
  @SerializedName("title"  ) var title  : String = "",
  @SerializedName("body"   ) var body   : String = ""

)