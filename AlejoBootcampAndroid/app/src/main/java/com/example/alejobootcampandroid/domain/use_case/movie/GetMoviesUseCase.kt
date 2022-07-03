package com.example.alejobootcampandroid.domain.use_case.movie

import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.example.alejobootcampandroid.domain.movie.repository.MoviesLocalRepository
import com.example.alejobootcampandroid.domain.movie.repository.MoviesRemoteRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val movieLocalRepository: MoviesLocalRepository,
    private val movieRemoteRepository: MoviesRemoteRepository,
    private val insertMoviesUseCase: InsertMoviesIntoDatabaseUseCase
    ) {

    suspend operator fun invoke(listId: Int): List<MovieModel>{
        var movieList = movieLocalRepository.getAllMovies()
        return if (movieList.isNotEmpty()){
            movieList
        } else{
            movieList = movieRemoteRepository.getAllMovies(listId)
            //movieLocalRepository.insertMovies(movieList)
            insertMoviesUseCase(movieList)
            movieList
        }
    }
}


