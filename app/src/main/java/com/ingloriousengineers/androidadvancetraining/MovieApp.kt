package com.ingloriousengineers.androidadvancetraining

import android.app.Application

class MovieApp: Application() {
    companion object {
        val IMAGE_URL_BASE_PATH = "http://image.tmdb.org/t/p/w342"
    }

    override fun onCreate() {
        super.onCreate()
    }
}