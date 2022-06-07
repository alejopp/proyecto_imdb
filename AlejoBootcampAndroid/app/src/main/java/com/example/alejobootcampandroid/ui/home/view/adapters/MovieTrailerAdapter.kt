package com.example.alejobootcampandroid.ui.home.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.databinding.ItemMovieTrailerBinding
import com.example.alejobootcampandroid.model.MovieTrailer

class MovieTrailerAdapter(val movieTrailerList: List<MovieTrailer>): RecyclerView.Adapter<MovieTrailerAdapter.MovieTrailerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieTrailerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieTrailerViewHolder(layoutInflater.inflate(R.layout.item_movie_trailer,parent,false))
    }

    override fun onBindViewHolder(holder: MovieTrailerViewHolder, position: Int) {
        val item = movieTrailerList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = movieTrailerList.size

    inner class MovieTrailerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = ItemMovieTrailerBinding.bind(itemView)
        fun render(movieTrailerItem: MovieTrailer) {
            binding.ivHomeMovieTrailer.setImageResource(movieTrailerItem.movieTrailerImage)
            binding.ivHomePosterImage.setImageResource(movieTrailerItem.moviePosterImage)
            binding.tvHomeMovieTitle.text = movieTrailerItem.movieTitle
        }

    }
}