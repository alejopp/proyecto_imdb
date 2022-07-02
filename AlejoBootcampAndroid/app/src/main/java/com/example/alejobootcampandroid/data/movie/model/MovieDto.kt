package com.example.alejobootcampandroid.data.movie.model

import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("items")
    var moviesList: List<MovieItem>
)

data class MovieItem(
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