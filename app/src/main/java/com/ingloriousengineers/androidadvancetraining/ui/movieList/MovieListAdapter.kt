package com.ingloriousengineers.androidadvancetraining.ui.movieList

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ingloriousengineers.androidadvancetraining.MovieApp
import com.ingloriousengineers.androidadvancetraining.R
import com.ingloriousengineers.androidadvancetraining.data.Result
import com.squareup.picasso.Picasso

class MovieListAdapter(val movieList: List<Result>, val onClickListener: (Result, Int) -> Unit) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
       val rootView: View = LayoutInflater.from(viewGroup.context)
               .inflate(R.layout.layout_movie_row, viewGroup, false)
        return ViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.movieName.text = movieList.get(position).title
        viewHolder.release_date.text = movieList.get(position).release_date
        val imageUrl = MovieApp.BASE_URL + movieList.get(position).poster_path
        Picasso.get().load(imageUrl).into(viewHolder.movieImage);
        viewHolder.itemView.setOnClickListener { onClickListener(movieList.get(position), position) }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val movieImage: ImageView = itemView.findViewById(R.id.movie_image)
        val movieName: TextView = itemView.findViewById(R.id.movie_name)
        val release_date: TextView = itemView.findViewById(R.id.release_date)

     }

}
