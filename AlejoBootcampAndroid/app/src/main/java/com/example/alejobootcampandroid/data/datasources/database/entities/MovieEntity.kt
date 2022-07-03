package com.example.alejobootcampandroid.data.datasources.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.alejobootcampandroid.domain.movie.model.MovieModel

@Entity(tableName = "movie_table")
data class MovieEntity(
    @PrimaryKey @ColumnInfo(name = "title")val title: String,
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "background_image")val backgroundImage: String,
    @ColumnInfo(name = "genre") val genre: String,
    @ColumnInfo(name = "poster_image")val posterImage: String,
    @ColumnInfo(name = "release_date")val releaseDate: String,
    @ColumnInfo(name = "original_title")val originalTitle: String,
    @ColumnInfo(name = "overview")val overview: String,
    @ColumnInfo(name = "score_average")val scoreAverage: Float
    )

fun MovieModel.asEntityModel() = MovieEntity(
    id = id,
    title = title,
    backgroundImage = backgroundImage,
    posterImage = posterImage,
    releaseDate = releaseDate,
    originalTitle = originalTitle,
    overview = overview,
    scoreAverage = scoreAverage,
    genre = genre
)
