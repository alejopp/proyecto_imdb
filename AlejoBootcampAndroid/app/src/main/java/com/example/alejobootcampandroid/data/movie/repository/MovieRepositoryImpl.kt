package com.example.alejobootcampandroid.data.movie.repository

import com.example.alejobootcampandroid.app.Constants
import com.example.alejobootcampandroid.data.movie.model.MovieListResponse
import com.example.alejobootcampandroid.data.source.database.dao.MovieDao
import com.example.alejobootcampandroid.data.source.network.MovieApi
import com.example.alejobootcampandroid.domain.movie.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api: MovieApi) : MovieRepository {

    override suspend fun getAllMovies(listId: Int): MovieListResponse {
        return api.getMoviesList(listId,Constants.API_KEY)
    }

}