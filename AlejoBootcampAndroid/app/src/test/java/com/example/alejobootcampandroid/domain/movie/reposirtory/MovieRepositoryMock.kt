package com.example.alejobootcampandroid.domain.movie.reposirtory

import com.example.alejobootcampandroid.data.movie.model.MovieListResponse
import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.example.alejobootcampandroid.domain.movie.model.MovieTestBuilder
import com.example.alejobootcampandroid.domain.movie.repository.MovieRepository

class MovieRepositoryMock: MovieRepository {
    override suspend fun getAllMovies(listId: Int): MovieListResponse {
        val movieTestBuilder = MovieTestBuilder()
        var movieListResponse = MovieListResponse(emptyList())

        when(listId){
            1 -> {
                movieListResponse
            }
            2 -> {
                movieListResponse.moviesList = movieTestBuilder.buildList()
            }
            3 -> {
                movieListResponse.moviesList = listOf(
                    movieTestBuilder.setId(listId).setTitle("La última patada del mocho").setBackdropPath("https://www.google.com").setPosterPath("https://www.google.com").setReleaseDate("1980-12-12").setOriginalTitle("La última patada del mocho").setDescription("Un hombre mocho da su última patada").setScore(7.8).build(),
                    movieTestBuilder.setId(listId).setTitle("7 días bajo la poceta").setBackdropPath("https://www.google.com").setPosterPath("https://www.google.com").setReleaseDate("2000-06-12").setOriginalTitle("7 días bajo la poceta").setDescription("Un hombre pasa 7 días bajo una poceta").setScore(7.8).build(),
                    movieTestBuilder.setId(listId).setTitle("Betty la fea, la película").setBackdropPath("https://www.google.com").setPosterPath("https://www.google.com").setReleaseDate("2022-10-09").setOriginalTitle("Betty the movie").setDescription("La historia de como una secretaria fea tiene que luchar para triunfar").setScore(9.9).build()
                )
            }
        }

        return movieListResponse
    }
}