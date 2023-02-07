package com.example.alejobootcampandroid.data.source.remote.dto

import com.google.gson.annotations.SerializedName

data class TopRatedMovieDto (
    val id: Int,
    val title: String,
    @SerializedName("vote_average")
    val scoreAverage: Float,
    @SerializedName("poster_path")
    val posterImage: String,
    @SerializedName("overview")
    val description: String
    )