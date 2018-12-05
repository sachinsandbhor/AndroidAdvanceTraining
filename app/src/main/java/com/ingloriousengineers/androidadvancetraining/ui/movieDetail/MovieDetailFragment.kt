package com.ingloriousengineers.androidadvancetraining.ui.movieDetail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ingloriousengineers.androidadvancetraining.R
import com.ingloriousengineers.androidadvancetraining.data.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_movie_detail.*


class MovieDetailFragment : Fragment() {

    lateinit var movie: Result

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments!!.containsKey("movie")) {
            movie = arguments!!.get("movie") as Result
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (movie != null) {
            movie_detail_name.text = movie.title
            release_detail_date.text = movie.release_date
            val imageUrl = MovieApp.IMAGE_URL_BASE_PATH + movie.poster_path
            Picasso.get().load(imageUrl).into(movie_detail_image)
            overview.text = movie.overview
        }
    }

    companion object {
        fun newInstance(movie: Result): MovieDetailFragment {
            val movieDetailFragment = MovieDetailFragment()
            val arg = Bundle()
            arg.putSerializable("movie", movie)
            movieDetailFragment.arguments = arg
            return movieDetailFragment
        }
    }
}
