package com.example.alejobootcampandroid.domain.movie.repository

import com.example.alejobootcampandroid.data.movie.model.MovieDto
import com.example.alejobootcampandroid.data.source.database.entities.MovieEntity
import com.example.alejobootcampandroid.domain.movie.model.MovieModel

interface MovieRepository {
    suspend fun getAllMoviesFromApi(listId: Int): List<MovieModel>
    suspend fun getAllMoviesFromDatabase(): List<MovieModel>
    suspend fun insertMoviesIntoDatabase(movies: List<MovieEntity>)
    suspend fun clearMovies()
}

