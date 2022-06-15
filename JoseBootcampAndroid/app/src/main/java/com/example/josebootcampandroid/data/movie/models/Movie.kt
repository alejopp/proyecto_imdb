package com.example.josebootcampandroid.data.movie.models

data class Movie(
    val id: Int,
    val imageUrl: String,
    val date: String,
    val title: String,
    val description: String,
    val vote_average: Double
)