package com.example.alejobootcampandroid.presentation.ui.movie.view


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.app.Constants
import com.example.alejobootcampandroid.databinding.ItemMovieBinding
import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.squareup.picasso.Picasso

class MovieSearchAdapter constructor(private val movieList: List<MovieModel>) :
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

        fun render(movieModel: MovieModel){
            binding.tvMovieTitle.text = movieModel.title
            binding.tvYear.text = movieModel.releaseDate
            Picasso.get().load("${Constants.BASE_IMAGE_URL}${movieModel.backgroundImage}").into(binding.ivMovie)
            itemView.setOnClickListener{
                val bundle = bundleOf("movieItem" to movieModel)
                itemView.findNavController().navigate(R.id.navigation_detail,bundle)
            }
        }

    }
}