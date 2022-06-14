package com.example.josebootcampandroid.presentation.ui.home


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.josebootcampandroid.R
import com.example.josebootcampandroid.data.home.MovieProfileModel
import com.example.josebootcampandroid.databinding.ItemPrincipalImagesBinding


class MovieProfileAdapater(val listMovieProfile:List<MovieProfileModel>) : RecyclerView.Adapter<MovieProfileAdapater.MovieProfileViewHolders>() {
    inner class MovieProfileViewHolders(view: View): RecyclerView.ViewHolder(view){
        private val binding = ItemPrincipalImagesBinding.bind(view)
        fun render(item: MovieProfileModel) {
            binding.tvPrincipalName.text = item.principalTitle
            binding.tvTrailer.text = item.typeTrailer
            binding.ivBackgroundPhoto.setImageResource(item.principalImages)
            binding.ivBackgraundMini.setImageResource(item.secondImage)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieProfileViewHolders {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieProfileViewHolders(layoutInflater.inflate(R.layout.item_principal_images,parent,false))
    }

    override fun onBindViewHolder(holder: MovieProfileViewHolders, position: Int) {
        val item = listMovieProfile[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = listMovieProfile.size
}