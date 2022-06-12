package com.example.alejobootcampandroid.presentation.ui.movie.search.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.databinding.ItemMovieBinding
import com.example.alejobootcampandroid.data.movie.Movie

class MovieSearchAdapter constructor(private val movieList: List<Movie>) :
    RecyclerView.Adapter<MovieSearchAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = movieList[position]
        holder.render(movie)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemMovieBinding.bind(itemView)

        fun render(movieModel: Movie){
            binding.tvMovieTitle.text = movieModel.title
            binding.tvYear.text = movieModel.year
            binding.ivMovie.setImageResource(movieModel.image)
            binding.tvStar.text = movieModel.protagonist

            itemView.setOnClickListener{
                itemView.findNavController().navigate(R.id.navigation_detail)
            }
        }

    }
}