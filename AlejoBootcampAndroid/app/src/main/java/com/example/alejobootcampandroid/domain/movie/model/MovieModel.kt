package com.example.alejobootcampandroid.domain.movie.model


import com.example.alejobootcampandroid.data.movie.model.MovieItem
import com.example.alejobootcampandroid.data.datasources.database.entities.MovieEntity
import java.io.Serializable


data class MovieModel(
    val id: Int,
    val title: String,
    val backgroundImage: String,
    val posterImage: String,
    val releaseDate: String,
    val originalTitle: String,
    val overview: String,
    val scoreAverage: Float
    ): Serializable

fun MovieItem.mapToMovieModel() =
    MovieModel(id, title, backgroundImage, posterImage, releaseDate, originalTitle, overview, scoreAverage)

fun MovieEntity.mapToMovieModel() =
    MovieModel(id, title, backgroundImage, posterImage, releaseDate, originalTitle, overview, scoreAverage)
