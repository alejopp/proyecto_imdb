package com.example.alejobootcampandroid.domain.movie.reposirtory.top_rated_movie

import com.example.alejobootcampandroid.data.movie.model.TopRatedMovieListResponse
import com.example.alejobootcampandroid.domain.movie.model.TopRatedMovieTestBuilder

class TopRatedDefaultMovieRepositoryMock: TopRatedMovieRepository {

    val topRatedMovieBuilde = TopRatedMovieTestBuilder()
    val topRatedMovieListResponse = TopRatedMovieListResponse(topRatedMovieBuilde.buildList())

    override suspend fun getAllTopRatedMovies(): TopRatedMovieListResponse {
        return topRatedMovieListResponse
    }

}