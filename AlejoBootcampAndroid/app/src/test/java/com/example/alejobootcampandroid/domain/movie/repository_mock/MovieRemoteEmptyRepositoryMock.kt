package com.example.alejobootcampandroid.domain.movie.repository_mock

import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.example.alejobootcampandroid.domain.movie.model.TopRatedMovieModel
import com.example.alejobootcampandroid.domain.movie.repository.MovieRepository

class MovieRemoteEmptyRepositoryMock: MovieRepository {

    override suspend fun getAllMovies(listId: Int): List<MovieModel> {
        var movieListResponse = listOf<MovieModel>()

        when(listId){
            1 -> {
                movieListResponse
            }
            2 -> {
                movieListResponse = listOf(
                    MovieModel(1,"Eternals","/ocUp7DJBIc8VJgLEw1prcyK1dYv.jpg","Action","/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg","2021-12-15","Eternals","The Eternals are a team of ancient aliens who have been living on Earth in secret",7.1f)
                )
            }
            3 -> {
                movieListResponse = listOf(
                    MovieModel(1,"Betty la fea la película","/ocUp7DJBIc8VJgLEw1prcyK1dYv.jpg","Action","/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg","2004-12-15","Eternals","The Eternals are a team of ancient aliens who have been living on Earth in secret",7.1f),
                    MovieModel(1,"Eternals","/ocUp7DJBIc8VJgLEw1prcyK1dYv.jpg","Action","/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg","2021-12-15","Eternals","The Eternals are a team of ancient aliens who have been living on Earth in secret",7.1f),
                    MovieModel(1,"Vulgarcito","/ocUp7DJBIc8VJgLEw1prcyK1dYv.jpg","Action","/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg","2014-12-15","Eternals","The Eternals are a team of ancient aliens who have been living on Earth in secret",7.1f),
                )
            }
        }

        return movieListResponse
    }

    override suspend fun getAllTopRatedMovies(): List<TopRatedMovieModel> {
        return emptyList()
    }


}