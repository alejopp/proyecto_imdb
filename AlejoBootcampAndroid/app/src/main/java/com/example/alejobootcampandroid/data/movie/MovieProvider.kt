package com.example.alejobootcampandroid.data.movie

import com.example.alejobootcampandroid.R

class MovieProvider {

    companion object{
        val movieList = arrayListOf<MovieModel>(
            MovieModel("HP and the philosopher st", R.drawable.harry_potter, "2001","Default star"),
            MovieModel("Coco", R.drawable.harry_potter,"2001","Default star"),
            MovieModel("Justice League", R.drawable.harry_potter,"2001","Default star"),
            MovieModel("Thor: Ragnarok", R.drawable.harry_potter, "2001","Default star"),
            MovieModel("Star Wars The Last Jedi", R.drawable.harry_potter, "2001","Default star"),
            MovieModel("Coco", R.drawable.harry_potter,"2001","Default star"),
            MovieModel("Justice League", R.drawable.harry_potter,"2001","Default star")
        )
    }
}