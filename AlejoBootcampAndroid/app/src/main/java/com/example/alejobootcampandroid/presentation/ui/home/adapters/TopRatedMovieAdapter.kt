package com.example.alejobootcampandroid.presentation.ui.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.utils.Constants
import com.example.alejobootcampandroid.databinding.ItemBestSelectionsBinding
import com.example.alejobootcampandroid.domain.movie.model.TopRatedMovieModel
import com.squareup.picasso.Picasso

class TopRatedMovieAdapter(private val topRatedMoviesList: List<TopRatedMovieModel>):
    RecyclerView.Adapter<TopRatedMovieAdapter.BestSelectionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSelectionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BestSelectionViewHolder(layoutInflater
            .inflate(R.layout.item_best_selections,parent,false))
    }

    override fun onBindViewHolder(holder: BestSelectionViewHolder, position: Int) {
        val item = topRatedMoviesList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = topRatedMoviesList.size

    inner class BestSelectionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = ItemBestSelectionsBinding.bind(itemView)
        fun render(bestSelectionItem: TopRatedMovieModel) {
            binding.tvHomeMovieScore.text = bestSelectionItem.scoreAverage.toString()
            binding.tvHomeBestselectionMovieTitle.text = bestSelectionItem.title
            Picasso.get().load("${Constants.BASE_IMAGE_URL}${bestSelectionItem.posterImage}")
                .into(binding.ivHomeBestSelection)
        }

    }
}