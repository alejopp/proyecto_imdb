package com.example.alejobootcampandroid.domain.use_case.movie

import com.example.alejobootcampandroid.data.movie.repository.MovieRemoteRepositoryImpl

class GetMoviesUseCase {
    private val movieRepository = MovieRemoteRepositoryImpl()

    suspend operator fun invoke() = movieRepository.getAllMovies()
}