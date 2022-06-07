package com.example.alejobootcampandroid.data.providers

import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.model.Movie

class MovieProvider {

    companion object{
        val movieList = listOf<Movie>(
            Movie("Star Wars The Last Jedi", R.drawable.harry_potter, "2001","Default star"),
            Movie("Coco", R.drawable.harry_potter,"2001","Default star"),
            Movie("Justice League", R.drawable.harry_potter,"2001","Default star"),
            Movie("Thor: Ragnarok", R.drawable.harry_potter, "2001","Default star"),
            Movie("Star Wars The Last Jedi", R.drawable.harry_potter, "2001","Default star"),
            Movie("Coco", R.drawable.harry_potter,"2001","Default star"),
            Movie("Justice League", R.drawable.harry_potter,"2001","Default star")
        )
    }
}