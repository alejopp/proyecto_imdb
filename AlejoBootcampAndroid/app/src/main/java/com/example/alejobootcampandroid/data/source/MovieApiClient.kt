package com.example.alejobootcampandroid.data.source

import com.example.alejobootcampandroid.app.Constants
import com.example.alejobootcampandroid.data.movie.models.MovieListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieApiClient {

    suspend fun getMovies(): MovieListResponse{

        return withContext(Dispatchers.IO) {
            val response = ApiRestManager.createApi().getMoviesList(3,Constants.API_KEY)
            response
        }

    }
}