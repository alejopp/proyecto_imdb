package com.example.alejobootcampandroid.data.movie.model

import com.example.alejobootcampandroid.data.movie.model.dto.TopRatedMovieDto
import com.google.gson.annotations.SerializedName

data class TopRatedMovieListResponse (
    @SerializedName("results")
    var topRatedMoviesList: List<TopRatedMovieDto>
)