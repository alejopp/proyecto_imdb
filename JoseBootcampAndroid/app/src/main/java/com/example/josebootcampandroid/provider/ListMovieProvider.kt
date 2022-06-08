package com.example.josebootcampandroid.provider

import com.example.josebootcampandroid.R
import com.example.josebootcampandroid.model.ListMovieProfile

class ListMovieProvider {
    companion object{
        val listMovieProfile = listOf<ListMovieProfile>(
            ListMovieProfile("Transformer 1","3.2", R.drawable.transformer1),
            ListMovieProfile("Transformer 2","4.5",R.drawable.transformer2)
        )
    }
}