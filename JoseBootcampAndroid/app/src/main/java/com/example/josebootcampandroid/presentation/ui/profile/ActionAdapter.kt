package com.example.josebootcampandroid.presentation.ui.profile


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.josebootcampandroid.R
import com.example.josebootcampandroid.data.profile.ActionsModel
import com.example.josebootcampandroid.databinding.ItemRecommendationBinding


class ActionAdapter(val listActions:List<ActionsModel>) : RecyclerView.Adapter<ActionAdapter.ActionViewHolders>() {
    inner class ActionViewHolders(view: View): RecyclerView.ViewHolder(view){
        private val binding = ItemRecommendationBinding.bind(view)
        fun render(item: ActionsModel) {
            binding.tvUserRateMovie.text = item.nombre
            binding.tvUserRatings.text = item.observaciones
            binding.tvUserRatingsValue.text = item.valoracion
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionViewHolders {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ActionViewHolders(layoutInflater.inflate(R.layout.item_recommendation,parent,false))
    }

    override fun onBindViewHolder(holder: ActionViewHolders, position: Int) {
        val item = listActions[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = listActions.size
}