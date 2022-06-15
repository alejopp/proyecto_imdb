package com.example.josebootcampandroid.data.movie.models

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("items")
    var moviesList: List<Movie>
)