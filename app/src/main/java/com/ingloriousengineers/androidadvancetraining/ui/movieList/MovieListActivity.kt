package com.ingloriousengineers.androidadvancetraining.ui.movieList

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.FrameLayout
import com.google.gson.Gson
import com.ingloriousengineers.androidadvancetraining.*
import com.ingloriousengineers.androidadvancetraining.data.MovieList
import com.ingloriousengineers.androidadvancetraining.data.Result
import com.ingloriousengineers.androidadvancetraining.ui.movieDetail.MovieDetail
import com.ingloriousengineers.androidadvancetraining.ui.movieDetail.MovieDetailFragment

class MovieListActivity : AppCompatActivity() {

    private val TAG: String = MovieListActivity::class.java.simpleName
    private var twoPane = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(findViewById<FrameLayout>(R.id.movie_detail_container) != null) {
            twoPane = true
        }
        loadData()
    }

    private fun loadData() {
        val result = Gson().fromJson(loadDataFromJson(), MovieList::class.java).results as List<Result>
        val recyclerView: RecyclerView = findViewById(R.id.movie_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MovieListAdapter(result) { movie: Result, position: Int ->
            if(twoPane) {
                val movieDetailFragment: MovieDetailFragment = MovieDetailFragment.newInstance(movie)
                supportFragmentManager.beginTransaction()
                        .disallowAddToBackStack()
                        .replace(R.id.movie_detail_container, movieDetailFragment)
                        .commit()
            } else {
                val movieIntent = Intent(this@MovieListActivity, MovieDetail::class.java)
                movieIntent.putExtra("movie", movie)
                startActivity(movieIntent)
            }
        }
    }

    private fun loadDataFromJson(): String {
       val response: String = applicationContext.assets.open("Movies.json").bufferedReader().use {
            it.readText()
        }
        return response
    }

}
