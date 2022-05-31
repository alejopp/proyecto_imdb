package com.example.alejobootcampandroid.providers

import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.models.MovieTrailer

class MovieTrailerProvider {
    companion object{
        val movieTrailerList = listOf<MovieTrailer>(
            MovieTrailer(R.drawable.light_year_background, R.drawable.light_year, "Light Year"),
            MovieTrailer(R.drawable.harry_potter, R.drawable.hp_poster, "Harry Potter and the prisoner of Askaban")
        )
    }
}