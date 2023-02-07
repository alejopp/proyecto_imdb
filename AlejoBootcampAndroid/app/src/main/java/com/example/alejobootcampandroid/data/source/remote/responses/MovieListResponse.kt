package com.example.alejobootcampandroid.data.source.remote.responses

import com.example.alejobootcampandroid.data.source.remote.dto.MovieDto
import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("items")
    var moviesList: List<MovieDto>
)