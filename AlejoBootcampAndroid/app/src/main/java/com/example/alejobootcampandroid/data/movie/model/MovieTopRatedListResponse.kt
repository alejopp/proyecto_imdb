package com.example.alejobootcampandroid.data.movie.model

import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.example.alejobootcampandroid.domain.movie.model.TopRatedMovieModel
import com.google.gson.annotations.SerializedName

data class MovieTopRatedListResponse (
    @SerializedName("results")
    var topRatedMoviesList: List<TopRatedMovieModel>
)