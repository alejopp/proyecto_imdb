package com.example.alejobootcampandroid.data.source.local.dao

import androidx.room.*
import com.example.alejobootcampandroid.data.source.local.entities.MovieEntity
import com.example.alejobootcampandroid.data.source.local.entities.TopRatedMovieEntity

@Dao
interface MovieDao {

    //Movies
    @Query("SELECT * FROM movie_table")
    suspend fun getAllMovies(): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMovies(movies: List<MovieEntity>)

    //Top rated movies
    @Query("SELECT * FROM top_rated_movie_table")
    suspend fun getAllTopRatedMoviesFromDatabase(): List<TopRatedMovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopRatedMoviesIntoDatabase(topRatedMovies: List<TopRatedMovieEntity>)
}