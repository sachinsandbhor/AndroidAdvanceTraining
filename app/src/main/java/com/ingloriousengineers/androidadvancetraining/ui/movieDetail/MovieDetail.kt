package com.ingloriousengineers.androidadvancetraining.ui.movieDetail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ingloriousengineers.androidadvancetraining.R
import com.ingloriousengineers.androidadvancetraining.data.Result

class MovieDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        if(intent.hasExtra("movie")) {
           val movie = intent.extras.get("movie") as Result
            supportActionBar?.title = movie.title
            val movieDetailFragment: MovieDetailFragment = MovieDetailFragment.newInstance(movie)
            supportFragmentManager.beginTransaction()
                    .disallowAddToBackStack()
                    .add(R.id.movie_detail, movieDetailFragment)
                    .commit()
        }
    }
}
