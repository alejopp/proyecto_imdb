package com.example.alejobootcampandroid.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.databinding.ItemBestSelectionsBinding
import com.example.alejobootcampandroid.model.BestSelection

class BestSelectionAdapter(val bestSelectionList: List<BestSelection>):RecyclerView.Adapter<BestSelectionAdapter.BestSelectionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSelectionViewHolder  {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BestSelectionViewHolder(layoutInflater.inflate(R.layout.item_best_selections,parent,false))
    }

    override fun onBindViewHolder(holder: BestSelectionViewHolder, position: Int) {
        val item = bestSelectionList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = bestSelectionList.size

    inner class BestSelectionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = ItemBestSelectionsBinding.bind(itemView)
        fun render(bestSelectionItem: BestSelection) {
            binding.tvHomeMovieScore.text = bestSelectionItem.score
            binding.tvHomeBestselectionMovieTitle.text = bestSelectionItem.movieTitle
            binding.ivHomeBestSelection.setImageResource(bestSelectionItem.movieImage)
        }

    }
}