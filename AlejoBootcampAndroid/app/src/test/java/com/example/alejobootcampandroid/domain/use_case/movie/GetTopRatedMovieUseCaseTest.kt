package com.example.alejobootcampandroid.domain.use_case.movie

import com.example.alejobootcampandroid.data.movie.model.TopRatedMovieListResponse
import com.example.alejobootcampandroid.domain.movie.model.TopRatedMovieModel
import com.example.alejobootcampandroid.domain.movie.repository_mock.MovieRemoteEmptyRepositoryMock
import com.example.alejobootcampandroid.domain.movie.repository_mock.MovieRemoteRepositoryMock
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GetTopRatedMovieUseCaseTest {

    @Test
    fun `when the api return an empty list`() = runBlocking {
        //Arrange
        val topRatedMovieEmptyRepositoryMock = MovieRemoteEmptyRepositoryMock()
        val expected = emptyList<TopRatedMovieListResponse>()

        //Action
        val response = topRatedMovieEmptyRepositoryMock.getAllTopRatedMovies()

        //Assert
        assertEquals(response, expected)
    }

    @Test
    fun `when the api return a full list`() = runBlocking {
        //Arrange
        val topRatedMovieFullRepositoryMock = MovieRemoteRepositoryMock()
        val expected = listOf(
            TopRatedMovieModel(1,"Betty la fea la película",9.5f,"/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg","The Eternals are a team of ancient aliens who have been..."),
            TopRatedMovieModel(2,"La última pata del mocho",8.6f,"/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg","The Eternals are a team of ancient aliens who have been..."),
            TopRatedMovieModel(3,"7 días bajo la poceta",8.3f,"/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg","The Eternals are a team of ancient aliens who have been...")
        )

        //Action
        val response = topRatedMovieFullRepositoryMock.getAllTopRatedMovies()

        //Assert
        assertEquals(response, expected)

    }

    @Test
    fun `is score correct`() = runBlocking {
        //Arrange
        val topRatedDefaultMovieRepositoryMock = MovieRemoteRepositoryMock()
        val expected = 8.6f

        //Action
        val response = topRatedDefaultMovieRepositoryMock.getAllTopRatedMovies()

        //Assert
        assertEquals(response[1].scoreAverage, expected)
    }
}