package com.example.alejobootcampandroid.domain.movie.reposirtory.top_rated_movie

import com.example.alejobootcampandroid.data.movie.model.TopRatedMovieListResponse
import com.example.alejobootcampandroid.domain.movie.model.TopRatedMovieTestBuilder

class TopRatedMovieFullRepositoryMock: TopRatedMovieRepository{

    private val topRatedMovieTestBuilder = TopRatedMovieTestBuilder()
    private var topRatedMovieListResponse = TopRatedMovieListResponse(
        listOf(
            topRatedMovieTestBuilder.setId(1).setTitle("La última patada del mocho").setPosterPath("https://www.google.com").setDescription("Un hombre mocho da su última patada").setScore(7.8).build(),
            topRatedMovieTestBuilder.setId(1).setTitle("7 días bajo la poceta").setPosterPath("https://www.google.com").setDescription("Un hombre pasa 7 días bajo una poceta").setScore(7.8).build(),
            topRatedMovieTestBuilder.setId(1).setTitle("Betty la fea, la película").setPosterPath("https://www.google.com").setDescription("La historia de como una secretaria fea tiene que luchar para triunfar").setScore(9.9).build()
        )
    )

    override suspend fun getAllTopRatedMovies(): TopRatedMovieListResponse {
        return topRatedMovieListResponse
    }
}