package com.example.alejobootcampandroid.data.di

import com.example.alejobootcampandroid.data.repository.MovieRepositoryImpl
import com.example.alejobootcampandroid.data.service.ConfigServiceImpl
import com.example.alejobootcampandroid.data.source.local.dao.MovieDao
import com.example.alejobootcampandroid.data.source.remote.MovieApiService
import com.example.alejobootcampandroid.domain.repository.MovieRepository
import com.example.alejobootcampandroid.domain.service.ConfigService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(apiService: MovieApiService, movieDao: MovieDao):  MovieRepository{
        return MovieRepositoryImpl(apiService, movieDao)
    }

    @Provides
    @Singleton
    fun provideConfigService():  ConfigService {
        return ConfigServiceImpl()
    }

}