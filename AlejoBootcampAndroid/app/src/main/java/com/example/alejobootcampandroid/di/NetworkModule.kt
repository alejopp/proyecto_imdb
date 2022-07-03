package com.example.alejobootcampandroid.di

import com.example.alejobootcampandroid.app.Constants
import com.example.alejobootcampandroid.data.movie.repositoies.MoviesLocalRepositoryImpl
import com.example.alejobootcampandroid.data.datasources.database.dao.MoviesDao
import com.example.alejobootcampandroid.data.datasources.remote.MovieApiService
import com.example.alejobootcampandroid.data.movie.repositoies.MoviesRemoteRepositoryImpl
import com.example.alejobootcampandroid.domain.movie.repository.MoviesLocalRepository
import com.example.alejobootcampandroid.domain.movie.repository.MoviesRemoteRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val gson = GsonBuilder()
        .setLenient()
        .create()

    @Provides
    @Singleton
    fun provideMovieApi(): MovieApiService {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Constants.MOVIE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(MovieApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideMoviesLocalRepository(moviesDao: MoviesDao): MoviesLocalRepository {
        return MoviesLocalRepositoryImpl( moviesDao)
    }

    @Provides
    @Singleton
    fun provideMoviesRemoteRepository(apiService: MovieApiService): MoviesRemoteRepository {
        return MoviesRemoteRepositoryImpl(apiService)
    }
}