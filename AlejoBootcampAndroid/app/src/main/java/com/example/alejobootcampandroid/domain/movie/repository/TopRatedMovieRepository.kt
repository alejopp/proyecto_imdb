package com.example.alejobootcampandroid.domain.movie.repository

import com.example.alejobootcampandroid.data.movie.model.MovieTopRatedListResponse

interface TopRatedMovieRepository {
    suspend fun getAllToRatedMovies(): MovieTopRatedListResponse
}