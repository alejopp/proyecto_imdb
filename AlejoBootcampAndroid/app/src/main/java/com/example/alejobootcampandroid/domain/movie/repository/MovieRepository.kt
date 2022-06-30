package com.example.alejobootcampandroid.domain.movie.repository

import com.example.alejobootcampandroid.data.movie.model.MovieListResponse

interface MovieRepository {
    suspend fun getAllMovies(listId: Int): MovieListResponse
}

