package com.example.alejobootcampandroid.di

import android.content.Context
import androidx.room.Room
import com.example.alejobootcampandroid.app.Constants
import com.example.alejobootcampandroid.data.datasources.database.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext contex: Context) =
        Room.databaseBuilder(contex,MovieDatabase::class.java,Constants.MOVIE_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideMovieDao(db: MovieDatabase) = db.getMovieDao()

}