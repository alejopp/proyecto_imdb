package com.example.alejobootcampandroid.data.datasources.database.dao

import androidx.room.*
import com.example.alejobootcampandroid.data.datasources.database.entities.MovieEntity
import com.example.alejobootcampandroid.data.datasources.database.entities.TopRatedMovieEntity

@Dao
interface MoviesDao {

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