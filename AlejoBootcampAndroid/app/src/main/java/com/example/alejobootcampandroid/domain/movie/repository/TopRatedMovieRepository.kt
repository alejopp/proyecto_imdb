package com.example.alejobootcampandroid.domain.movie.repository

import com.example.alejobootcampandroid.data.movie.model.TopRatedMovieListResponse

interface TopRatedMovieRepository {
    suspend fun getAllTopRatedMovies(): TopRatedMovieListResponse
}