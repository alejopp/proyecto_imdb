package com.example.alejobootcampandroid.data.source.remote.responses

import com.example.alejobootcampandroid.data.source.remote.dto.GenreDto

data class MovieGenresResponse(
    val genres: List<GenreDto>
)