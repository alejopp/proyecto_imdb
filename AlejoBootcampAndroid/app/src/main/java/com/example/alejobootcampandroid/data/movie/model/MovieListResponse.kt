package com.example.alejobootcampandroid.data.movie.model

import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("items")
    var moviesList: List<MovieModel>
)