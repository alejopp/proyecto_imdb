package com.example.alejobootcampandroid.domain.model

import java.io.Serializable


data class MovieModel(
    val id: Int,
    val title: String,
    val backgroundImage: String,
    val genre: String,
    val posterImage: String,
    val releaseDate: String,
    val originalTitle: String,
    val overview: String,
    val scoreAverage: Float
    ): Serializable




