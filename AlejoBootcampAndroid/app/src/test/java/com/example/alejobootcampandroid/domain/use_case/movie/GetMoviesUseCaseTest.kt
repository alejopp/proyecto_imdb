package com.example.alejobootcampandroid.domain.use_case.movie

import com.example.alejobootcampandroid.data.movie.model.MovieListResponse
import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.example.alejobootcampandroid.domain.movie.model.MovieTestBuilder
import com.example.alejobootcampandroid.domain.movie.reposirtory.MovieLocalRepositoryMock
import com.example.alejobootcampandroid.domain.movie.repository.MoviesLocalRepository
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class GetMoviesUseCaseTest{

    @RelaxedMockK
    private lateinit var movieRepository: MoviesLocalRepository

    lateinit var getMoviesUseCase: GetMoviesUseCase

/*    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getMoviesUseCase = GetMoviesUseCase(movieRepository)
    }*/

    @Test
    fun `when the api send an empty list`() = runBlocking{
        //Arrange
        val movieRepositoryMockito = MovieLocalRepositoryMock()
        val extected = MovieListResponse(emptyList())

        //Action
        val response = movieRepositoryMockito.getAllMoviesFromApi(1)

        // Assert
        assertEquals(response,extected)

    }

    @Test
    fun `when the api send a default movie`() = runBlocking{
        //Arrange
        val movieRepositoryMockito = MovieLocalRepositoryMock()
        val movieBuild = MovieTestBuilder()
            .setId(1)
            .setTitle("Eternals")
            .setBackdropPath("/c6H7Z4u73ir3cIoCteuhJh7UCAR.jpg")
            .setPosterPath("/lFByFSLV5WDJEv3KabbdAF959F2.jpg")
            .setReleaseDate("2021-11-03")
            .setOriginalTitle("Eternals")
            .setDescription("The Eternals are a team of ancient aliens who have been living on Earth in secret for thousands of years. When an unexpected tragedy forces them out of the shadows, they are forced to reunite against mankind’s most ancient enemy, the Deviants.")
            .setScore(7.7).buildList()

        val expected = movieBuild

        //Action
        val response = movieRepositoryMockito.getAllMoviesFromApi(2)

        // Assert
        assertEquals(response,expected)

    }


    @Test
    fun `when the api return a completed list of movies`() = runBlocking{
        //Arrange
        val movieRepositoryMockito = MovieLocalRepositoryMock()
        val movieBuild = MovieTestBuilder()
        val movieListMock = listOf<MovieModel>(
            movieBuild.setId(3).setTitle("La última patada del mocho").setBackdropPath("https://www.google.com").setPosterPath("https://www.google.com").setReleaseDate("1980-12-12").setOriginalTitle("La última patada del mocho").setDescription("Un hombre mocho da su última patada").setScore(7.8).build(),
            movieBuild.setId(3).setTitle("7 días bajo la poceta").setBackdropPath("https://www.google.com").setPosterPath("https://www.google.com").setReleaseDate("2000-06-12").setOriginalTitle("7 días bajo la poceta").setDescription("Un hombre pasa 7 días bajo una poceta").setScore(7.8).build(),
            movieBuild.setId(3).setTitle("Betty la fea, la película").setBackdropPath("https://www.google.com").setPosterPath("https://www.google.com").setReleaseDate("2022-10-09").setOriginalTitle("Betty the movie").setDescription("La historia de como una secretaria fea tiene que luchar para triunfar").setScore(9.9).build()
        )


        val expected = movieListMock

        //Action
        val response = movieRepositoryMockito.getAllMoviesFromApi(3)

        // Assert
        assertEquals(response,expected)

    }




}