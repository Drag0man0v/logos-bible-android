package com.example.logos

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// Root Application class used to initialize Hilt
@HiltAndroidApp
class App: Application(){
    // Can override onCreate() to run initialization code
}