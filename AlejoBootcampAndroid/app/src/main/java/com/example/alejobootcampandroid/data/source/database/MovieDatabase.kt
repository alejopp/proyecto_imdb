package com.example.alejobootcampandroid.data.source.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.alejobootcampandroid.data.source.database.dao.MovieDao
import com.example.alejobootcampandroid.data.source.database.entities.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract  class MovieDatabase: RoomDatabase() {

    abstract fun getMovieDao(): MovieDao

}