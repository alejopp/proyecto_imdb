package com.example.alejobootcampandroid.domain.movie.repository

import com.example.alejobootcampandroid.data.movie.model.MovieListResponse
import com.example.alejobootcampandroid.data.movie.model.TopRatedMovieListResponse
import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.example.alejobootcampandroid.domain.movie.model.TopRatedMovieModel

interface MoviesRemoteRepository {

    suspend fun getAllMovies(listId: Int): List<MovieModel>
    suspend fun getAllTopRatedMovies(): List<TopRatedMovieModel>
}