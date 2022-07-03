package com.example.alejobootcampandroid.data.movie.repositoies

import com.example.alejobootcampandroid.app.Constants
import com.example.alejobootcampandroid.data.datasources.remote.MovieApiService
import com.example.alejobootcampandroid.data.movie.model.MovieListResponse
import com.example.alejobootcampandroid.data.movie.model.TopRatedMovieListResponse
import com.example.alejobootcampandroid.data.movie.model.dto.MovieDto
import com.example.alejobootcampandroid.data.movie.model.dto.TopRatedMovieDto
import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.example.alejobootcampandroid.domain.movie.model.TopRatedMovieModel
import com.example.alejobootcampandroid.domain.movie.model.asDomainModel
import com.example.alejobootcampandroid.domain.movie.repository.MoviesRemoteRepository
import javax.inject.Inject

class MoviesRemoteRepositoryImpl @Inject constructor(private val api: MovieApiService): MoviesRemoteRepository {

    override suspend fun getAllMovies(listId: Int): List<MovieModel> {
        val response: MovieListResponse = api.getMoviesList(listId, Constants.API_KEY)
        return response.moviesList.map { movieDto ->
            movieDto.asDomainModel()
        }
    }

    override suspend fun getAllTopRatedMovies(): List<TopRatedMovieModel> {
        val response: TopRatedMovieListResponse = api.getTopRatedMoviesList(Constants.API_KEY)
        return response.topRatedMoviesList.map { topRatedMovieDto ->
            topRatedMovieDto.asDomainModel()
        }
    }
}