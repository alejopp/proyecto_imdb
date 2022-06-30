package com.example.alejobootcampandroid.data.source

import com.example.alejobootcampandroid.data.movie.model.MovieListResponse
import com.example.alejobootcampandroid.data.movie.model.MovieTopRatedListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("list/{id}")
    suspend fun getMoviesList(
        @Path("id") listId : Int?,
        @Query("api_key") apiKey: String?
    ): MovieListResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedMoviesList(
        @Query("api_key") apiKey: String?
    ): MovieTopRatedListResponse
}