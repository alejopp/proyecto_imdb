package com.example.alejobootcampandroid.data.datasources.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "top_rated_movie_table")
data class TopRatedMovieEntity(
    @ColumnInfo(name = "id") val id: Int,
    @PrimaryKey @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "scoreAverge") val vote_average: Number,
    @ColumnInfo(name = "posterImage") val poster_path: String,
    @ColumnInfo(name = "description") val overview: String
    )
