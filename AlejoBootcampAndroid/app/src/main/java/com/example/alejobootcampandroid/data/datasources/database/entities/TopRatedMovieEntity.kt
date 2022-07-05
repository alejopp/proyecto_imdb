package com.example.alejobootcampandroid.data.datasources.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.alejobootcampandroid.domain.movie.model.TopRatedMovieModel

@Entity(tableName = "top_rated_movie_table")
data class TopRatedMovieEntity(
    @ColumnInfo(name = "id") val id: Int,
    @PrimaryKey @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "scoreAverge") val scoreAverage: Float,
    @ColumnInfo(name = "posterImage") val posterImage: String,
    @ColumnInfo(name = "description") val overview: String
    )


fun TopRatedMovieModel.asEntityModel() = TopRatedMovieEntity(
    id, title, scoreAverage, posterImage, overview
)
