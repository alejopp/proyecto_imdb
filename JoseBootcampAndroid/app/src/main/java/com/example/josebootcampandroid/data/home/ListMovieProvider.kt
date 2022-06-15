package com.example.josebootcampandroid.data.home

import com.example.josebootcampandroid.R

class ListMovieProvider {
    companion object{
        val listMovieProfile = listOf<ListMovieProfileModel>(
            ListMovieProfileModel("Transformer 1","3.2", R.drawable.transformer1),
            ListMovieProfileModel("Transformer 2","4.5",R.drawable.transformer2),
            ListMovieProfileModel("Transformer 3","4.8",R.drawable.transformer3_movie),
            ListMovieProfileModel("Transformer 4","3.8",R.drawable.transformer4_movie),
            ListMovieProfileModel("Transformer 5","3.2",R.drawable.transformer5_movie),
            ListMovieProfileModel("Transformer 6","2.5",R.drawable.transformer6_movie)
        )
    }
}