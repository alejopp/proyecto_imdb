package com.example.alejobootcampandroid.data.movie.repositoies

import com.example.alejobootcampandroid.data.datasources.database.dao.MoviesDao
import com.example.alejobootcampandroid.data.datasources.database.entities.MovieEntity
import com.example.alejobootcampandroid.data.datasources.database.entities.TopRatedMovieEntity
import com.example.alejobootcampandroid.data.datasources.database.entities.asEntityModel
import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.example.alejobootcampandroid.domain.movie.model.TopRatedMovieModel
import com.example.alejobootcampandroid.domain.movie.model.asDomainModel
import com.example.alejobootcampandroid.domain.movie.repository.MoviesLocalRepository
import javax.inject.Inject

class MoviesLocalRepositoryImpl @Inject constructor(private val moviesDao: MoviesDao) : MoviesLocalRepository {

    override suspend fun getAllMovies(): List<MovieModel> {
        val response: List<MovieEntity> = moviesDao.getAllMovies()
        return response.map { movieEntity ->
            movieEntity.asDomainModel()
        }
    }

    override suspend fun insertMovies(movies: List<MovieModel>) {
        moviesDao.insertAllMovies(movies.map { it.asEntityModel() })
    }

    override suspend fun getAllTopRatedMovies(): List<TopRatedMovieModel> {
        val response: List<TopRatedMovieEntity> = moviesDao.getAllTopRatedMoviesFromDatabase()
        return response.map {topRatedMovie ->
            topRatedMovie.asDomainModel()}
    }

    override suspend fun inserTopRatedtMovies(movies: List<TopRatedMovieModel>) {
        moviesDao.insertTopRatedMoviesIntoDatabase(movies.map { topRatedMovieModel ->
            topRatedMovieModel.asEntityModel() })
    }

}