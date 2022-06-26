package com.example.alejobootcampandroid.domain.use_case.movie

import com.example.alejobootcampandroid.data.movie.repository.MovieRepositoryImpl
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val movieRepository: MovieRepositoryImpl) {

    suspend operator fun invoke() = movieRepository.getAllMovies()

}