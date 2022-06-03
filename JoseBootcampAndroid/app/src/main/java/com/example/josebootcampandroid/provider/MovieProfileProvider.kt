package com.example.josebootcampandroid.provider

import com.example.josebootcampandroid.R
import com.example.josebootcampandroid.model.MovieProfile

class MovieProfileProvider {
    companion object{
        val listMovieProfile = listOf<MovieProfile>(
            MovieProfile("Transformer1","Trailer Oficial", R.drawable.transformer1,R.drawable.transformer2),
            MovieProfile("Transformer2","Trailer Oficial",R.drawable.transformer2,R.drawable.transformer3)
        )
    }
}