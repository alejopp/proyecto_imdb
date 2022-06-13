package com.example.alejobootcampandroid.data.movie

import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.data.movie.Movie

class MovieProvider {

    companion object{
        val movieList = arrayListOf<Movie>(
            Movie("HP and the philosopher st", R.drawable.harry_potter, "2001","Default star"),
            Movie("Coco", R.drawable.harry_potter,"2001","Default star"),
            Movie("Justice League", R.drawable.harry_potter,"2001","Default star"),
            Movie("Thor: Ragnarok", R.drawable.harry_potter, "2001","Default star"),
            Movie("Star Wars The Last Jedi", R.drawable.harry_potter, "2001","Default star"),
            Movie("Coco", R.drawable.harry_potter,"2001","Default star"),
            Movie("Justice League", R.drawable.harry_potter,"2001","Default star")
        )
    }
}