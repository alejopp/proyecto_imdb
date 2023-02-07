package com.example.alejobootcampandroid.data.movie.model.dto

import com.google.gson.annotations.SerializedName

class MovieDto (
    @SerializedName("backdrop_path")
    val backgroundImage: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    val id: Int,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    @SerializedName("poster_path")
    val posterImage: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
    @SerializedName("vote_average")
    val scoreAverage: Float,
)