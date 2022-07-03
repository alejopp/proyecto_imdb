package com.example.alejobootcampandroid.domain.use_case.movie

import com.example.alejobootcampandroid.domain.movie.model.TopRatedMovieModel
import com.example.alejobootcampandroid.domain.movie.repository.MoviesLocalRepository
import javax.inject.Inject

class InsertTopRatedMoviesIntoDatabaseUseCase @Inject constructor(
    private val moviesLocalRepository: MoviesLocalRepository
) {
    suspend operator fun invoke(topRatedMoviesList: List<TopRatedMovieModel>) {
        moviesLocalRepository.inserTopRatedtMovies(topRatedMoviesList)
    }
}