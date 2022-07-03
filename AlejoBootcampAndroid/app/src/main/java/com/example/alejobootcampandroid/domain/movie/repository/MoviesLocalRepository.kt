package com.example.alejobootcampandroid.domain.movie.repository

import com.example.alejobootcampandroid.data.datasources.database.entities.MovieEntity
import com.example.alejobootcampandroid.data.datasources.database.entities.TopRatedMovieEntity
import com.example.alejobootcampandroid.data.movie.model.TopRatedMovieListResponse
import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.example.alejobootcampandroid.domain.movie.model.TopRatedMovieModel

interface MoviesLocalRepository {

    //Movies
    suspend fun getAllMovies(): List<MovieModel>
    suspend fun insertMovies(movies: List<MovieModel>)

    //Top rated movies
    suspend fun getAllTopRatedMovies(): List<TopRatedMovieModel>
    suspend fun inserTopRatedtMovies(movies: List<TopRatedMovieModel>)

}

