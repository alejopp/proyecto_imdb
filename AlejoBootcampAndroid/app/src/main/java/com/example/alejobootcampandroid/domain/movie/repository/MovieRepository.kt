package com.example.alejobootcampandroid.domain.movie.repository

import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.example.alejobootcampandroid.domain.movie.model.TopRatedMovieModel

interface MovieRepository {

    suspend fun getAllMoviesFromApi(listId: Int): List<MovieModel>
    suspend fun getAllTopRatedMoviesFromApi(): List<TopRatedMovieModel>

    //Movies
    suspend fun getAllMoviesFromDatabase(): List<MovieModel>
    suspend fun insertMoviesIntoDatabase(movies: List<MovieModel>)

    //Top rated movies
    suspend fun getAllTopRatedMoviesFromDatabase(): List<TopRatedMovieModel>
    suspend fun insertTopRatedMoviesIntoDatabase(movies: List<TopRatedMovieModel>)
}