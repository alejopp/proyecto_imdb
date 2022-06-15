package com.example.josebootcampandroid.domain.repositories

import com.example.josebootcampandroid.data.movie.models.Movie

interface MovieRepository {
    fun getAllMovies(): List<Movie>
}