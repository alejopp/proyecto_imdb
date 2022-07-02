package com.example.alejobootcampandroid.domain.movie.model


import com.example.alejobootcampandroid.data.movie.model.MovieItem
import com.google.gson.annotations.SerializedName

class MovieTestBuilder {
    var id = 1
    var title: String = "Eternals"
    var backdrop_path: String = "/c6H7Z4u73ir3cIoCteuhJh7UCAR.jpg"
    var poster_path: String = "/lFByFSLV5WDJEv3KabbdAF959F2.jpg"
    var release_date: String = "2021-11-03"
    var original_title: String  = "Eternals"
    var overview: String = "The Eternals are a team of ancient aliens who have been living on Earth in secret for thousands of years. When an unexpected tragedy forces them out of the shadows, they are forced to reunite against mankind’s most ancient enemy, the Deviants."
    var vote_average: Number = 7.7

    fun setId(id: Int): MovieTestBuilder{
        this.id = id
        return  this
    }

    fun setTitle(title: String): MovieTestBuilder{
        this.title = title
        return this
    }

    fun setBackdropPath(backdropPath: String): MovieTestBuilder{
        this.backdrop_path = backdropPath
        return this
    }

    fun setPosterPath(posterPath: String): MovieTestBuilder{
        this.poster_path = posterPath
        return this
    }

    fun setReleaseDate(releaseDate: String): MovieTestBuilder{
        this.release_date = releaseDate
        return this
    }

    fun setOriginalTitle(originalTitle: String): MovieTestBuilder{
        this.original_title = originalTitle
        return this
    }

    fun setDescription(description: String): MovieTestBuilder{
        this.overview = description
        return this
    }

    fun setScore(score: Number): MovieTestBuilder{
        this.vote_average = score
        return this
    }

    fun build(): MovieModel {
        return MovieModel(id,
            title,original_title,overview, poster_path,release_date,title,vote_average)
    }

    fun buildList(): List<MovieModel>{
        return listOf(build())
    }
}

