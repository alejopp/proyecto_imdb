package com.example.alejobootcampandroid.data.datasources.remote

import com.example.alejobootcampandroid.data.movie.model.MovieGenresResponse
import com.example.alejobootcampandroid.data.movie.model.MovieListResponse
import com.example.alejobootcampandroid.data.movie.model.TopRatedMovieListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {
    @GET("list/{id}")
    suspend fun getMoviesList(
        @Path("id") listId : Int?,
        @Query("api_key") apiKey: String?
    ): MovieListResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedMoviesList(
        @Query("api_key") apiKey: String?
    ): TopRatedMovieListResponse

    @GET("genre/movie/list")
    suspend fun getMoviesGenresList(
        @Query("api_key") apiKey: String?
    ): MovieGenresResponse
}