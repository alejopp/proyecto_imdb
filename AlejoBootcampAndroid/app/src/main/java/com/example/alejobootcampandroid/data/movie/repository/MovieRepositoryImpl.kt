package com.example.alejobootcampandroid.data.movie.repository

import com.example.alejobootcampandroid.app.Constants
import com.example.alejobootcampandroid.data.movie.model.MovieDto
import com.example.alejobootcampandroid.data.movie.model.MovieItem
import com.example.alejobootcampandroid.data.source.database.dao.MovieDao
import com.example.alejobootcampandroid.data.source.database.entities.MovieEntity
import com.example.alejobootcampandroid.data.source.network.MovieApi
import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.example.alejobootcampandroid.domain.movie.model.mapToMovieModel
import com.example.alejobootcampandroid.domain.movie.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api: MovieApi, private val movieDao: MovieDao) : MovieRepository {

    override suspend fun getAllMoviesFromApi(listId: Int): List<MovieModel> {
        val response: MovieDto = api.getMoviesList(listId,Constants.API_KEY)
        return response.moviesList.map { movieItem ->
            movieItem.mapToMovieModel()
        }
    }

    override suspend fun getAllMoviesFromDatabase(): List<MovieModel> {
        val response: List<MovieEntity> = movieDao.getAllMovies()
        return response.map { movieEntity ->
            movieEntity.mapToMovieModel()
        }
    }

    override suspend fun insertMoviesIntoDatabase(movies: List<MovieEntity>) {
       movieDao.insertAllMovies(movies)
    }

    override suspend fun clearMovies() {
        movieDao.deleteAllMovies()
    }


}