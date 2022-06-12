package com.example.alejobootcampandroid.data.home

import com.example.alejobootcampandroid.R

class MovieTrailerProvider {
    companion object{
        val movieTrailerList = listOf<MovieTrailerModel>(
            MovieTrailerModel(R.drawable.light_year_background, R.drawable.light_year, "Light Year"),
            MovieTrailerModel(R.drawable.harry_potter, R.drawable.hp_poster, "Harry Potter and the prisoner of Askaban")
        )
    }
}