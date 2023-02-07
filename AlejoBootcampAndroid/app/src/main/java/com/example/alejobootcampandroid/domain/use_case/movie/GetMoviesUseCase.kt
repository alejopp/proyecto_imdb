package com.example.alejobootcampandroid.domain.use_case.movie

import com.example.alejobootcampandroid.data.source.ResponseStatus
import com.example.alejobootcampandroid.domain.model.MovieModel
import com.example.alejobootcampandroid.domain.repository.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    suspend operator fun invoke(listId: Int): ResponseStatus<List<MovieModel>>{
            return movieRepository.getMovies(listId)
    }

}


