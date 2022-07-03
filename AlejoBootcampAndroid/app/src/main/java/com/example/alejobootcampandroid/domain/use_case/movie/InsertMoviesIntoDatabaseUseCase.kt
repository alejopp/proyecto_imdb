package com.example.alejobootcampandroid.domain.use_case.movie

import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.example.alejobootcampandroid.domain.movie.repository.MoviesLocalRepository
import javax.inject.Inject

class InsertMoviesIntoDatabaseUseCase @Inject constructor(
    private val moviesLocalRepository: MoviesLocalRepository) {

    suspend operator fun invoke(movies: List<MovieModel>){
        moviesLocalRepository.insertMovies(movies)
    }

}