package com.example.alejobootcampandroid.data.movie.repository

import com.example.alejobootcampandroid.data.movie.model.MovieListResponse
import com.example.alejobootcampandroid.data.source.MovieApiClient
import com.example.alejobootcampandroid.domain.movie.repository.MovieRepository

class MovieRemoteRepositoryImpl : MovieRepository {
    private val api = MovieApiClient()

    override suspend fun getAllMovies(): MovieListResponse {
        return api.getMovies()
    }
}