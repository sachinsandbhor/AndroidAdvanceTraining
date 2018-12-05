package com.ingloriousengineers.androidadvancetraining.ui.movieList

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.google.gson.Gson
import com.ingloriousengineers.androidadvancetraining.*
import com.ingloriousengineers.androidadvancetraining.data.MovieList
import com.ingloriousengineers.androidadvancetraining.data.Result
import com.ingloriousengineers.androidadvancetraining.ui.movieDetail.MovieDetail

class MovieListActivity : AppCompatActivity() {

    private val TAG: String = MovieListActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
    }

    private fun loadData() {
        val result = Gson().fromJson(loadDataFromJson(), MovieList::class.java).results as List<Result>
        val recyclerView: RecyclerView = findViewById(R.id.movie_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MovieListAdapter(result) { movie: Result, position: Int ->
            val movieIntent = Intent(this@MovieListActivity, MovieDetail::class.java)
            movieIntent.putExtra("movie", movie)
            startActivity(movieIntent)
        }
    }

    private fun loadDataFromJson(): String {
       val response: String = applicationContext.assets.open("Movies.json").bufferedReader().use {
            it.readText()
        }
        return response
    }

}
