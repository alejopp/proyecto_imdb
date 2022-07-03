package com.example.alejobootcampandroid.domain.use_case.movie


import android.util.Log
import com.example.alejobootcampandroid.data.source.database.entities.mapToDatabaseEntity
import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.example.alejobootcampandroid.domain.movie.repository.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository, ) {

    suspend operator fun invoke(listId: Int): List<MovieModel>{
        var movieList = movieRepository.getAllMoviesFromDatabase()
        return if(movieList.isNotEmpty()){
            movieList
        }else{
            movieList = movieRepository.getAllMoviesFromApi(listId)
            movieRepository.insertMoviesIntoDatabase(movieList.map { movie ->
                movie.mapToDatabaseEntity()
            })
            movieList
        }
    }
}


