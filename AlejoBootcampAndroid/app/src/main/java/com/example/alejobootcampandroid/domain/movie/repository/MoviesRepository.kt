package com.example.alejobootcampandroid.domain.movie.repository

import com.example.alejobootcampandroid.data.datasources.database.entities.MovieEntity
import com.example.alejobootcampandroid.data.movie.model.TopRatedMovieListResponse
import com.example.alejobootcampandroid.domain.movie.model.MovieModel

interface MoviesRepository {

    //Remote datasource
    suspend fun getAllMoviesFromApi(listId: Int): List<MovieModel>
    suspend fun getAllTopRatedMovies(): TopRatedMovieListResponse

    //Local datasource
    suspend fun getAllMoviesFromDatabase(): List<MovieModel>
    suspend fun insertMoviesIntoDatabase(movies: List<MovieEntity>)
    suspend fun clearMovies()
}

