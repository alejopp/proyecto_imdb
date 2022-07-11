package com.example.alejobootcampandroid.data.movie.repository

import com.example.alejobootcampandroid.data.datasources.database.dao.MovieDao
import com.example.alejobootcampandroid.data.datasources.database.entities.MovieEntity
import com.example.alejobootcampandroid.data.datasources.database.entities.TopRatedMovieEntity
import com.example.alejobootcampandroid.data.datasources.database.entities.asEntityModel
import com.example.alejobootcampandroid.utils.Constants
import com.example.alejobootcampandroid.data.datasources.remote.MovieApiService
import com.example.alejobootcampandroid.data.movie.model.MovieListResponse
import com.example.alejobootcampandroid.data.movie.model.TopRatedMovieListResponse
import com.example.alejobootcampandroid.data.movie.model.dto.GenreDto
import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.example.alejobootcampandroid.domain.movie.model.TopRatedMovieModel
import com.example.alejobootcampandroid.domain.movie.model.asDomainModel
import com.example.alejobootcampandroid.domain.movie.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApiService,
    private val movieDao: MovieDao
): MovieRepository {

    override suspend fun getAllMoviesFromApi(listId: Int): List<MovieModel> {
        val genresIds: List<GenreDto> = getMovieGenres()
        return withContext(Dispatchers.IO) {
            val response: MovieListResponse = api.getMoviesList(listId, Constants.API_KEY)
            response.moviesList.map { movieDto ->
                movieDto.asDomainModel(genresIds)
            }
        }
    }

    override suspend fun getAllTopRatedMoviesFromApi(): List<TopRatedMovieModel> {
        return withContext(Dispatchers.IO){
            val response: TopRatedMovieListResponse = api.getTopRatedMoviesList(Constants.API_KEY)
            response.topRatedMoviesList.map { topRatedMovieDto ->
                topRatedMovieDto.asDomainModel()
            }
        }
    }

    override suspend fun getAllMoviesFromDatabase(): List<MovieModel> {
        return withContext(Dispatchers.IO){
            val response: List<MovieEntity> = movieDao.getAllMovies()
            response.map { movieEntity ->
                movieEntity.asDomainModel()
            }
        }
    }

    override suspend fun insertMoviesIntoDatabase(movies: List<MovieModel>)
    = withContext(Dispatchers.IO){
        movieDao.insertAllMovies(movies.map { it.asEntityModel() })
    }

    override suspend fun getAllTopRatedMoviesFromDatabase(): List<TopRatedMovieModel> {
        return withContext(Dispatchers.IO){
            val response: List<TopRatedMovieEntity> = movieDao.getAllTopRatedMoviesFromDatabase()
            response.map {topRatedMovie ->
                topRatedMovie.asDomainModel()}
        }
    }

    override suspend fun insertTopRatedMoviesIntoDatabase(
        movies: List<TopRatedMovieModel>) = withContext(Dispatchers.IO) {
        movieDao.insertTopRatedMoviesIntoDatabase(movies.map { topRatedMovieModel ->
            topRatedMovieModel.asEntityModel() })
    }

    private suspend fun getMovieGenres(): List<GenreDto>{
        return withContext(Dispatchers.IO){
            val response = api.getMoviesGenresList(Constants.API_KEY)
            response.genres
        }

    }
}