package com.example.alejobootcampandroid.data.mappers

import com.example.alejobootcampandroid.data.source.local.entities.MovieEntity
import com.example.alejobootcampandroid.data.source.remote.dto.GenreDto
import com.example.alejobootcampandroid.data.source.remote.dto.MovieDto
import com.example.alejobootcampandroid.domain.model.MovieModel


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

fun MovieDto.asDomainModel(genresDto: List<GenreDto>): MovieModel {
    val genres = genreIds.map{ genresDto.find{ obj -> obj.id == it}}.map{it?.name}  as List<String>
    return MovieModel(id, title, backgroundImage,
        genre = genres[0],posterImage, releaseDate, originalTitle, overview, scoreAverage)
}


fun MovieEntity.asDomainModel() =
    MovieModel(id, title, backgroundImage, genre,posterImage, releaseDate, originalTitle, overview, scoreAverage)