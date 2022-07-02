package com.example.alejobootcampandroid.di

import com.example.alejobootcampandroid.app.Constants
import com.example.alejobootcampandroid.data.movie.repository.MovieRepositoryImpl
import com.example.alejobootcampandroid.data.movie.repository.TopRatedMovieRepositoryImpl
import com.example.alejobootcampandroid.data.datasources.database.dao.MovieDao
import com.example.alejobootcampandroid.data.datasources.remote.MovieApi
import com.example.alejobootcampandroid.domain.movie.repository.MoviesRepository
import com.example.alejobootcampandroid.domain.movie.repository.TopRatedMovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{

    @Provides
    @Singleton
    fun provideMovieApi(): MovieApi {
        return Retrofit.Builder()
            .baseUrl(Constants.MOVIE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: MovieApi, movieDao: MovieDao): MoviesRepository {
        return MovieRepositoryImpl(api, movieDao)
    }

    @Provides
    @Singleton
    fun provideTopRatedMovieRepository(api: MovieApi): TopRatedMovieRepository {
        return TopRatedMovieRepositoryImpl(api)
    }

}