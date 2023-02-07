package com.example.alejobootcampandroid.domain.repository

import com.example.alejobootcampandroid.domain.movie.model.MovieModel

interface MovieRepository {

    suspend fun getMovies(): ResponseStatus<List<MovieModel>>
}