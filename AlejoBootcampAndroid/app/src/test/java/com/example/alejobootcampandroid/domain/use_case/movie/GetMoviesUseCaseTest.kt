package com.example.alejobootcampandroid.domain.use_case.movie

import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.example.alejobootcampandroid.domain.movie.repository_mock.MovieRemoteRepositoryMock
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class GetMoviesUseCaseTest{

    @Test
    fun `when the api send an empty movie list`() = runBlocking{
        //Arrange
        val movieRepositoryMockito = MovieRemoteRepositoryMock()
        val expected = emptyList<MovieModel>()

        //Action
        val response = movieRepositoryMockito.getAllMovies(1)

        // Assert
        assertEquals(response,expected)

    }

    @Test
    fun `when the api send a default movie`() = runBlocking{
        //Arrange
        val movieRepositoryMockito = MovieRemoteRepositoryMock()
        val expected = listOf(
            MovieModel(1,"Eternals","/ocUp7DJBIc8VJgLEw1prcyK1dYv.jpg","Action","/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg","2021-12-15","Eternals","The Eternals are a team of ancient aliens who have been living on Earth in secret",7.1f)
        )

        //Action
        val response = movieRepositoryMockito.getAllMovies(2)

        // Assert
        assertEquals(response,expected)

    }

    @Test
    fun `when the api return a completed list of movies`() = runBlocking{
        //Arrange
        val movieRepositoryMockito = MovieRemoteRepositoryMock()
        val expected = listOf(
            MovieModel(1,"Betty la fea la película","/ocUp7DJBIc8VJgLEw1prcyK1dYv.jpg","Action","/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg","2004-12-15","Eternals","The Eternals are a team of ancient aliens who have been living on Earth in secret",7.1f),
            MovieModel(1,"Eternals","/ocUp7DJBIc8VJgLEw1prcyK1dYv.jpg","Action","/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg","2021-12-15","Eternals","The Eternals are a team of ancient aliens who have been living on Earth in secret",7.1f),
            MovieModel(1,"Vulgarcito","/ocUp7DJBIc8VJgLEw1prcyK1dYv.jpg","Action","/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg","2014-12-15","Eternals","The Eternals are a team of ancient aliens who have been living on Earth in secret",7.1f),
        )

        //Action
        val response = movieRepositoryMockito.getAllMovies(3)

        // Assert
        assertEquals(response,expected)
    }

    @Test
    fun`is a release date field of the movie list response correct`() = runBlocking {

        //Arrange
        val movieRepositoryMockito = MovieRemoteRepositoryMock()
        val expected = "2014-12-15"

        //Action
        val response = movieRepositoryMockito.getAllMovies(3)

        //Assert
        assertEquals(response[2].releaseDate, expected)
    }

}