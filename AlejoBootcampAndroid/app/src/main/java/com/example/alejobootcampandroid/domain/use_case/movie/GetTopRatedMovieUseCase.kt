package com.example.alejobootcampandroid.domain.use_case.movie

import com.example.alejobootcampandroid.data.source.ResponseStatus
import com.example.alejobootcampandroid.domain.model.TopRatedMovieModel
import com.example.alejobootcampandroid.domain.repository.MovieRepository
import javax.inject.Inject

class GetTopRatedMovieUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(): ResponseStatus<List<TopRatedMovieModel>>{
       return movieRepository.getTopRatedMovies()
    }
}