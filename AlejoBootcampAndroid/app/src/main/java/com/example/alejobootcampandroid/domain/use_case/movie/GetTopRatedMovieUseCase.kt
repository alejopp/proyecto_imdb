package com.example.alejobootcampandroid.domain.use_case.movie

import com.example.alejobootcampandroid.domain.movie.repository.TopRatedMovieRepository
import javax.inject.Inject

class GetTopRatedMovieUseCase @Inject constructor(private val topRatedMovieRepository: TopRatedMovieRepository) {
    suspend operator fun invoke() = topRatedMovieRepository.getAllTopRatedMovies()
}