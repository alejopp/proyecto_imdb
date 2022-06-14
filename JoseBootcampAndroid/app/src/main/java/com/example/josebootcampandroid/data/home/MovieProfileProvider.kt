package com.example.josebootcampandroid.data.home

import com.example.josebootcampandroid.R

class MovieProfileProvider {
    companion object{
        val listMovieProfile = listOf<MovieProfileModel>(
            MovieProfileModel("Transformer1","Trailer Oficial", R.drawable.transformer1,R.drawable.transformer2),
            MovieProfileModel("Transformer2","Trailer Oficial",R.drawable.transformer2,R.drawable.transformer3)
        )
    }
}