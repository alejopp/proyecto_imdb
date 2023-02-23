package com.example.alejobootcampandroid.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.alejobootcampandroid.data.source.local.dao.MovieDao
import com.example.alejobootcampandroid.data.source.local.entities.MovieEntity
import com.example.alejobootcampandroid.data.source.local.entities.TopRatedMovieEntity

@Database(entities = [MovieEntity::class, TopRatedMovieEntity::class], version = 1)
abstract  class MovieDatabase: RoomDatabase() {
    abstract fun getMovieDao(): MovieDao

}