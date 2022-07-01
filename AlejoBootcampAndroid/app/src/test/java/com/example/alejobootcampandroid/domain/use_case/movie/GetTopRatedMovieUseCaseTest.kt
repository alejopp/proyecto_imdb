package com.example.alejobootcampandroid.domain.use_case.movie

import com.example.alejobootcampandroid.data.movie.model.TopRatedMovieListResponse
import com.example.alejobootcampandroid.domain.movie.model.TopRatedMovieTestBuilder
import com.example.alejobootcampandroid.domain.movie.reposirtory.top_rated_movie.TopRatedDefaultMovieRepositoryMock
import com.example.alejobootcampandroid.domain.movie.reposirtory.top_rated_movie.TopRatedMovieEmptyRepositoryMock
import com.example.alejobootcampandroid.domain.movie.reposirtory.top_rated_movie.TopRatedMovieFullRepositoryMock
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GetTopRatedMovieUseCaseTest {

    @Test
    fun `when the api return an empty list`() = runBlocking {
        //Arrange
        val topRatedMovieEmptyRepositoryMock = TopRatedMovieEmptyRepositoryMock()
        val expected = TopRatedMovieListResponse(emptyList())

        //Action
        val response = topRatedMovieEmptyRepositoryMock.getAllTopRatedMovies()

        //Assert
        assertEquals(response, expected)

    }

    @Test
    fun `when the api return a full list`() = runBlocking {
        //Arrange
        val topRatedMovieFullRepositoryMock = TopRatedMovieFullRepositoryMock()
        val topRatedMovieTestBuilder = TopRatedMovieTestBuilder()
        val topRateMovieListMock = listOf(
            topRatedMovieTestBuilder.setId(1).setTitle("La última patada del mocho")
                .setPosterPath("https://www.google.com")
                .setDescription("Un hombre mocho da su última patada").setScore(7.8).build(),
            topRatedMovieTestBuilder.setId(1).setTitle("7 días bajo la poceta")
                .setPosterPath("https://www.google.com")
                .setDescription("Un hombre pasa 7 días bajo una poceta").setScore(7.8).build(),
            topRatedMovieTestBuilder.setId(1).setTitle("Betty la fea, la película")
                .setPosterPath("https://www.google.com")
                .setDescription("La historia de como una secretaria fea tiene que luchar para triunfar")
                .setScore(9.9).build()
        )
        val expected = TopRatedMovieListResponse(topRateMovieListMock)

        //Action
        val response = topRatedMovieFullRepositoryMock.getAllTopRatedMovies()

        //Assert
        assertEquals(response, expected)

    }

    @Test
    fun `when the api return a single default top rated movie`() = runBlocking {
        //Arrange
        val topRatedDefaultMovieRepositoryMock = TopRatedDefaultMovieRepositoryMock()
        val topRatedMovieTestBuilder = TopRatedMovieTestBuilder()
        val expected = TopRatedMovieListResponse(
            listOf(
                topRatedMovieTestBuilder
                    .setId(1)
                    .setTitle("Schindlers list")
                    .setPosterPath("/loRmRzQXZeqG78TqZuyvSlEQfZb.jpg")
                    .setDescription("The true story of how businessman Oskar Schindler saved over a thousand Jewish lives from the Nazis while they worked as slaves in his factory during World War II.")
                    .setScore(8.6)
                    .build()
            )
        )

        //Action
        val response = topRatedDefaultMovieRepositoryMock.getAllTopRatedMovies()

        //Assert
        assertEquals(response, expected)
    }
}