package com.example.alejobootcampandroid.data.datasources.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.alejobootcampandroid.data.datasources.database.dao.MovieDao
import com.example.alejobootcampandroid.data.datasources.database.entities.MovieEntity
import com.example.alejobootcampandroid.data.datasources.database.entities.TopRatedMovieEntity

@Database(entities = [MovieEntity::class, TopRatedMovieEntity::class], version = 1)
abstract  class MovieDatabase: RoomDatabase() {

    abstract fun getMovieDao(): MovieDao

}