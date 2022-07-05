package com.example.alejobootcampandroid.domain.use_case.movie

import com.example.alejobootcampandroid.domain.movie.model.TopRatedMovieModel
import com.example.alejobootcampandroid.domain.movie.repository.MoviesLocalRepository
import com.example.alejobootcampandroid.domain.movie.repository.MoviesRemoteRepository
import javax.inject.Inject

class GetTopRatedMovieUseCase @Inject constructor(
    private val moviesLocalRepository: MoviesLocalRepository,
    private val moviesRemoteRepository: MoviesRemoteRepository,
    private val insertTopRatedMoviesUseCase: InsertTopRatedMoviesIntoDatabaseUseCase
) {
    suspend operator fun invoke(): List<TopRatedMovieModel>{
       var topRatedMovieList = moviesLocalRepository.getAllTopRatedMovies()
       return topRatedMovieList.ifEmpty {
           topRatedMovieList = moviesRemoteRepository.getAllTopRatedMovies()
           insertTopRatedMoviesUseCase(topRatedMovieList)
           topRatedMovieList
       }
    }
}