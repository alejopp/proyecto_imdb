package com.example.alejobootcampandroid.domain.movie.reposirtory.top_rated_movie

import com.example.alejobootcampandroid.data.movie.model.TopRatedMovieListResponse
import com.example.alejobootcampandroid.domain.movie.model.TopRatedMovieTestBuilder
import com.example.alejobootcampandroid.domain.movie.repository.TopRatedMovieRepository

class TopRatedMovieEmptyRepositoryMock: TopRatedMovieRepository {

    var movieListResponse = TopRatedMovieListResponse(emptyList())
    override suspend fun getAllTopRatedMovies(): TopRatedMovieListResponse {
        return movieListResponse
    }
}