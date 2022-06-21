package com.example.alejobootcampandroid.domain.use_case.movie

import com.example.alejobootcampandroid.data.movie.repository.MovieRemoteRepositoryImpl
import com.example.alejobootcampandroid.data.movie.repository.TopRatedMovieRepositoryImpl

class GetTopRatedMovieUseCase {
    private val topRatedMovieRepository = TopRatedMovieRepositoryImpl()
    suspend operator fun invoke() = topRatedMovieRepository.getAllToRatedMovies()
}