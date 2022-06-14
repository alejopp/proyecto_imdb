package com.example.josebootcampandroid.data.home

import com.example.josebootcampandroid.R

class ListMovieProvider {
    companion object{
        val listMovieProfile = listOf<ListMovieProfileModel>(
            ListMovieProfileModel("Transformer 1","3.2", R.drawable.transformer1),
            ListMovieProfileModel("Transformer 2","4.5",R.drawable.transformer2)
        )
    }
}