package com.example.alejobootcampandroid.data.movie.repository

import com.example.alejobootcampandroid.app.Constants
import com.example.alejobootcampandroid.data.movie.model.MovieListResponse
import com.example.alejobootcampandroid.data.source.MovieApi
import com.example.alejobootcampandroid.domain.movie.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api: MovieApi) : MovieRepository {

    override suspend fun getAllMovies(): MovieListResponse {
        return api.getMoviesList(3,Constants.API_KEY)
    }
}