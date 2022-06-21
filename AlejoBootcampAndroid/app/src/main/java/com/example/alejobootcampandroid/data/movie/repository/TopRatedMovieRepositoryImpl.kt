package com.example.alejobootcampandroid.data.movie.repository

import com.example.alejobootcampandroid.data.movie.model.MovieListResponse
import com.example.alejobootcampandroid.data.movie.model.MovieTopRatedListResponse
import com.example.alejobootcampandroid.data.source.MovieApiClient
import com.example.alejobootcampandroid.domain.movie.repository.TopRatedMovieRepository

class TopRatedMovieRepositoryImpl: TopRatedMovieRepository {
    private val api = MovieApiClient()
    override suspend fun getAllToRatedMovies(): MovieTopRatedListResponse {
        return api.getTopRatedMovies()
    }
}