package com.example.alejobootcampandroid.data.datasources.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.alejobootcampandroid.data.datasources.database.dao.MovieDao
import com.example.alejobootcampandroid.data.datasources.database.dao.TopRatedMovieDao
import com.example.alejobootcampandroid.data.datasources.database.entities.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract  class MovieDatabase: RoomDatabase() {

    abstract fun getMovieDao(): MovieDao

    abstract fun getTopRatedMovieDao(): TopRatedMovieDao

}