package com.example.alejobootcampandroid.data.source.remote.responses

import com.example.alejobootcampandroid.data.source.remote.dto.TopRatedMovieDto
import com.google.gson.annotations.SerializedName

data class TopRatedMovieListResponse (
    @SerializedName("results")
    var topRatedMoviesList: List<TopRatedMovieDto>
)