package com.example.nativeposts

import android.app.Application
import com.example.nativeposts.data.AppContainer
import com.example.nativeposts.data.DefaultAppContainer

class NativePostsApp: Application() {

  lateinit var container: AppContainer

  override fun onCreate() {
    super.onCreate()
    container = DefaultAppContainer()
  }
}