package com.example.alejobootcampandroid.data.movie.repository


import com.example.alejobootcampandroid.app.Constants
import com.example.alejobootcampandroid.data.movie.model.TopRatedMovieListResponse
import com.example.alejobootcampandroid.data.source.MovieApi
import com.example.alejobootcampandroid.domain.movie.repository.TopRatedMovieRepository
import javax.inject.Inject

class TopRatedMovieRepositoryImpl @Inject constructor(private val api: MovieApi): TopRatedMovieRepository {

    override suspend fun getAllTopRatedMovies(): TopRatedMovieListResponse {
        return api.getTopRatedMoviesList(Constants.API_KEY)
    }

}