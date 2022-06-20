package com.example.alejobootcampandroid.domain.movie.model

data class TopRatedMovieModel(
     val id: Int,
     val title: String,
     val vote_average: Number,
     val backdrop_path: String)