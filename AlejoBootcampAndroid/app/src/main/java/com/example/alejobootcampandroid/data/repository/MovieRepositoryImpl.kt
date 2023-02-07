package com.example.alejobootcampandroid.data.repository

import com.example.alejobootcampandroid.data.mappers.asDomainModel
import com.example.alejobootcampandroid.data.mappers.asEntityModel
import com.example.alejobootcampandroid.data.source.ResponseStatus
import com.example.alejobootcampandroid.data.source.local.dao.MovieDao
import com.example.alejobootcampandroid.data.source.local.entities.asEntityModel
import com.example.alejobootcampandroid.data.source.makeRepositoryCall
import com.example.alejobootcampandroid.data.source.remote.MovieApiService
import com.example.alejobootcampandroid.data.source.remote.dto.GenreDto
import com.example.alejobootcampandroid.data.source.remote.responses.MovieGenresResponse
import com.example.alejobootcampandroid.domain.model.MovieModel
import com.example.alejobootcampandroid.domain.model.TopRatedMovieModel
import com.example.alejobootcampandroid.domain.model.asDomainModel
import com.example.alejobootcampandroid.domain.repository.MovieRepository
import com.example.alejobootcampandroid.utils.Constants
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApiService,
    private val movieDao: MovieDao
) : MovieRepository {

    override suspend fun getMovies(listId: Int): ResponseStatus<List<MovieModel>> =
        makeRepositoryCall {
            val genresIds: List<GenreDto> = getMovieGenres()
            if (movieDao.getAllMovies().isEmpty()) {
                api.getMoviesList(listId, Constants.API_KEY).moviesList.map { movieDto ->
                    movieDto.asDomainModel(genresIds)
                }.also { movies ->
                    movieDao.insertAllMovies(movies.map { movie ->
                        movie.asEntityModel()
                    })
                }
            } else {
                movieDao.getAllMovies().map { movieEntity ->
                    movieEntity.asDomainModel()
                }
            }
        }

    override suspend fun getTopRatedMovies(): ResponseStatus<List<TopRatedMovieModel>> =
        makeRepositoryCall {
            if (movieDao.getTopRatedMovies().isEmpty()) {
                api.getTopRatedMoviesList(Constants.API_KEY).topRatedMoviesList.map {  topRatedMovieDto ->
                    topRatedMovieDto.asDomainModel()
                }.also { topRatedMovies ->
                    movieDao.insertTopRatedMovies(topRatedMovies.map { topRatedMovie ->
                    topRatedMovie.asEntityModel()})
                }
            } else {
                movieDao.getTopRatedMovies().map { topRatedMovieEntity ->
                    topRatedMovieEntity.asDomainModel()
                }
            }
        }

    private suspend fun getMovieGenres(): List<GenreDto> {
        var response: MovieGenresResponse? = null
        try {
            response = api.getMoviesGenresList(Constants.API_KEY)
        } catch (e: Exception) {
            println(e.message)
        }
        return response?.genres ?: emptyList()
    }

}