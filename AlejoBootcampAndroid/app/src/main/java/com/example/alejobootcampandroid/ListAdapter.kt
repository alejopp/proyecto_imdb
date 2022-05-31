package com.example.alejobootcampandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.alejobootcampandroid.models.Movie

class ListAdapter constructor(private val movieList: List<Movie>) :
    RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = movieList[position]
        holder.title.text = movie.title
        holder.image.setBackgroundResource(movie.image)
        holder.year.text = "${movie.year}"
        holder.star.text = "${movie.protagonist}"
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tv_movie_title)
        val year: TextView = itemView.findViewById(R.id.tv_year)
        val image: ImageView = itemView.findViewById(R.id.iv_movie)
        val cardView: CardView = itemView.findViewById(R.id.carView)
        val star: TextView = itemView.findViewById(R.id.tv_star)

    }
}