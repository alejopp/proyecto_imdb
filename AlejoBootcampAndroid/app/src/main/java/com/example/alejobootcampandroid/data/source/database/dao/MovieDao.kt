package com.example.alejobootcampandroid.data.source.database.dao

import androidx.room.*
import com.example.alejobootcampandroid.data.source.database.entities.MovieEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table")
    suspend fun getAllMovies(): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMovies(movies: List<MovieEntity>)

    @Query("DELETE FROM movie_table")
    suspend fun deleteAllMovies()
}