package com.example.alejobootcampandroid.domain.use_case.movie


import com.example.alejobootcampandroid.data.datasources.database.entities.mapToDatabaseEntity
import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.example.alejobootcampandroid.domain.movie.repository.MoviesRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val movieRepository: MoviesRepository, ) {

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


