package com.example.alejobootcampandroid.domain.repositories

import com.example.alejobootcampandroid.data.movie.models.MovieListResponse

interface MovieRepository {
    interface MovieRepository {
        suspend fun getAllMovies(): MovieListResponse
    }
}