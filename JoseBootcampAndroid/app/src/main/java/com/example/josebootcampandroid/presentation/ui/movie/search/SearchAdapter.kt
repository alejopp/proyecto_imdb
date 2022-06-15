package com.example.josebootcampandroid.presentation.ui.movie.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.josebootcampandroid.R
import com.example.josebootcampandroid.data.movie.search.SearchModel
import com.example.josebootcampandroid.databinding.ItemMovieBinding

class SearchAdapter(val SearchMovie: List<SearchModel>) : RecyclerView.Adapter<SearchAdapter.SearchMovieViewHolders>() {
    inner class SearchMovieViewHolders(val view: View): RecyclerView.ViewHolder(view){
        private val binding = ItemMovieBinding.bind(view)
        fun render(item: SearchModel) {
            binding.tvMovieTitle.text = item.titlePrincipalOfSearch
            binding.tvYear.text = item.yearMovieOfSearch
            binding.tvStar.text = item.nameCastOfSearch
            binding.ivMovie.setImageResource(item.movieImageOfSearch)
            view.setOnClickListener { view.findNavController().navigate(R.id.navigation_detail)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMovieViewHolders {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SearchMovieViewHolders(layoutInflater.inflate(R.layout.item_movie,parent,false))
    }

    override fun onBindViewHolder(holder: SearchMovieViewHolders, position: Int) {
        val item = SearchMovie[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = SearchMovie.size
}