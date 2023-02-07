package com.example.alejobootcampandroid.domain.repository

import com.example.alejobootcampandroid.data.source.ResponseStatus
import com.example.alejobootcampandroid.domain.model.MovieModel
import com.example.alejobootcampandroid.domain.model.TopRatedMovieModel

interface MovieRepository {

    suspend fun getMovies(listId: Int): ResponseStatus<List<MovieModel>>
    suspend fun getTopRatedMovies(): ResponseStatus<List<TopRatedMovieModel>>

}