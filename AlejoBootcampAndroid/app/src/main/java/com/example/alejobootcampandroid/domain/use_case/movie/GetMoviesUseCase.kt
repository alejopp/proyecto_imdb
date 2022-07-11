package com.example.alejobootcampandroid.domain.use_case.movie

import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.example.alejobootcampandroid.domain.movie.repository.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    suspend operator fun invoke(listId: Int): List<MovieModel>{
        var movieList = movieRepository.getAllMoviesFromDatabase()
        return movieList.ifEmpty {
            movieList = movieRepository.getAllMoviesFromApi(listId)
            movieRepository.insertMoviesIntoDatabase(movieList)
            movieList
        }
    }
}


