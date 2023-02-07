package com.example.alejobootcampandroid.domain.movie.model

import com.example.alejobootcampandroid.data.source.local.entities.TopRatedMovieEntity
import com.example.alejobootcampandroid.data.source.remote.dto.TopRatedMovieDto

data class TopRatedMovieModel(
     val id: Int,
     val title: String,
     val scoreAverage: Float,
     val posterImage: String,
     val overview: String)

fun TopRatedMovieDto.asDomainModel() =
     TopRatedMovieModel(id, title, scoreAverage, posterImage, description)

fun TopRatedMovieEntity.asDomainModel() =
     TopRatedMovieModel(id, title, scoreAverage, posterImage, overview)