package com.example.alejobootcampandroid.data.datasources.database.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.alejobootcampandroid.data.datasources.database.entities.TopRatedMovieEntity

interface TopRatedMovieDao {

    @Query("SELECT * FROM top_rated_movie_table")
    suspend fun getAllTopRatedMovies(): List<TopRatedMovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopRatedMoviesIntoDatabase(topRatedMovies: List<TopRatedMovieEntity>)
}