package com.example.josebootcampandroid.presentation.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.josebootcampandroid.R
import com.example.josebootcampandroid.data.home.ListMovieProfileModel
import com.example.josebootcampandroid.databinding.ItemImagelasmejoresBinding


class ListMovieAdapter(val listMovie: List<ListMovieProfileModel>) : RecyclerView.Adapter<ListMovieAdapter.ListMovieViewHolders>() {
    inner class ListMovieViewHolders(view: View): RecyclerView.ViewHolder(view){
        private val binding = ItemImagelasmejoresBinding.bind(view)
        fun render(item: ListMovieProfileModel) {
            binding.tvNameMovie.text = item.titlePrincipal
            binding.tvPointMovie.text = item.moviePoint
            binding.ivPrincipalImage.setImageResource(item.movieImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMovieViewHolders {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ListMovieViewHolders(layoutInflater.inflate(R.layout.item_imagelasmejores,parent,false))
    }

    override fun onBindViewHolder(holder: ListMovieViewHolders, position: Int) {
        val item = listMovie[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = listMovie.size
}