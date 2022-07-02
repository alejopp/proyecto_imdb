package com.example.alejobootcampandroid.data.datasources.remote

import com.example.alejobootcampandroid.data.movie.model.MovieDto
import com.example.alejobootcampandroid.data.movie.model.TopRatedMovieListResponse

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("list/{id}")
    suspend fun getMoviesList(
        @Path("id") listId : Int?,
        @Query("api_key") apiKey: String?
    ): MovieDto

    @GET("movie/top_rated")
    suspend fun getTopRatedMoviesList(
        @Query("api_key") apiKey: String?
    ): TopRatedMovieListResponse
}