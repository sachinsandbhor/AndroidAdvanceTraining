package com.ingloriousengineers.androidadvancetraining

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MovieDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        if(intent.hasExtra("movie")) {
           val movie = intent.extras.get("movie")

        }
    }
}
