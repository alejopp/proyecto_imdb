package com.example.alejobootcampandroid.domain.use_case.movie

import com.example.alejobootcampandroid.domain.movie.model.TopRatedMovieModel
import com.example.alejobootcampandroid.domain.movie.repository.MovieRepository
import javax.inject.Inject

class GetTopRatedMovieUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(): List<TopRatedMovieModel>{
       var topRatedMovieList = movieRepository.getAllTopRatedMoviesFromDatabase()
       return topRatedMovieList.ifEmpty {
           topRatedMovieList = movieRepository.getAllTopRatedMoviesFromApi()
           movieRepository.insertTopRatedMoviesIntoDatabase(topRatedMovieList)
           topRatedMovieList
       }
    }
}