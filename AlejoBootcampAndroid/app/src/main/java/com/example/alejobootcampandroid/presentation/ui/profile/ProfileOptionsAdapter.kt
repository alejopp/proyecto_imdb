package com.example.alejobootcampandroid.presentation.ui.profile.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.databinding.ItemRecommendationBinding
import com.example.alejobootcampandroid.data.profile.ProfileOptionsModel

class ProfileOptionsAdapter(private val userOptionsList : List<ProfileOptionsModel>): RecyclerView.Adapter<ProfileOptionsAdapter.UserOptionsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserOptionsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UserOptionsViewHolder(layoutInflater.inflate(R.layout.item_recommendation,parent,false))
    }

    override fun onBindViewHolder(holder: UserOptionsViewHolder, position: Int) {
        val item = userOptionsList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = userOptionsList.size

    inner class UserOptionsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
       val binding = ItemRecommendationBinding.bind(itemView)

        fun render(userOptionsItem: ProfileOptionsModel){
            binding.tvUserRateMovie.text = userOptionsItem.description
            binding.tvUserRatings.text = userOptionsItem.title
            binding.tvUserRatingsValue.text = "${userOptionsItem.value}"
        }
    }

}