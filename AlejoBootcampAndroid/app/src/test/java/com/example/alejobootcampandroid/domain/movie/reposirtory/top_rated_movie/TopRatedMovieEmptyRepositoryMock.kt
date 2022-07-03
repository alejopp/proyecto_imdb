package com.example.alejobootcampandroid.domain.movie.reposirtory.top_rated_movie

import com.example.alejobootcampandroid.data.movie.model.TopRatedMovieListResponse

class TopRatedMovieEmptyRepositoryMock: TopRatedMovieRepository {

    var movieListResponse = TopRatedMovieListResponse(emptyList())
    override suspend fun getAllTopRatedMovies(): TopRatedMovieListResponse {
        return movieListResponse
    }
}