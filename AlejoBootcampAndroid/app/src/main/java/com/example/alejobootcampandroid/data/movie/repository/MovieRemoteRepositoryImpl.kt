package com.example.alejobootcampandroid.data.movie.repository

import com.example.alejobootcampandroid.data.movie.models.MovieListResponse
import com.example.alejobootcampandroid.data.source.MovieApiClient
import com.example.alejobootcampandroid.domain.repositories.MovieRepository

class MovieRemoteRepositoryImpl : MovieRepository.MovieRepository {
    private val api = MovieApiClient()

    override suspend fun getAllMovies(): MovieListResponse {
        return api.getMovies()
    }
}