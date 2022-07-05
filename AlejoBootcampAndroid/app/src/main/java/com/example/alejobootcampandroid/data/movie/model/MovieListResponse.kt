package com.example.alejobootcampandroid.data.movie.model

import com.example.alejobootcampandroid.data.movie.model.dto.MovieDto
import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("items")
    var moviesList: List<MovieDto>
)