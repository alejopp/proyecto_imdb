package com.example.alejobootcampandroid.domain.movie.model

import com.example.alejobootcampandroid.data.datasources.database.entities.MovieEntity
import com.example.alejobootcampandroid.data.movie.model.dto.GenreDto
import com.example.alejobootcampandroid.data.movie.model.dto.MovieDto
import java.io.Serializable


data class MovieModel(
    val id: Int,
    val title: String,
    val backgroundImage: String,
    val genre: String,
    val posterImage: String,
    val releaseDate: String,
    val originalTitle: String,
    val overview: String,
    val scoreAverage: Float
    ): Serializable

fun MovieDto.asDomainModel(genresDto: List<GenreDto>): MovieModel {
    val genres = genreIds.map{ genresDto.find{ obj -> obj.id == it}}.map{it?.name}  as List<String>
    return MovieModel(id, title, backgroundImage,
        genre = genres[0],posterImage, releaseDate, originalTitle, overview, scoreAverage)
}


fun MovieEntity.asDomainModel() =
    MovieModel(id, title, backgroundImage, genre,posterImage, releaseDate, originalTitle, overview, scoreAverage)


