package com.example.alejobootcampandroid.data.source.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
data class MovieEntity (
    @PrimaryKey @ColumnInfo(name = "title")val title: String,
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "background_image")val backdropImage: String,
    @ColumnInfo(name = "poster_image")val posterImage: String,
    @ColumnInfo(name = "release_date")val releaseDate: String,
    @ColumnInfo(name = "original_title")val originalTitle: String,
    @ColumnInfo(name = "overview")val overview: String,
    @ColumnInfo(name = "score_average")val scoreAverage: Number
    )