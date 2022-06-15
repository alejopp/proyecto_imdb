package com.example.josebootcampandroid.data.movie.search

import com.example.josebootcampandroid.R
import com.example.josebootcampandroid.data.movie.search.SearchModel

class SearchProvider {
    companion object{
        val SearchOfMovie = listOf<SearchModel>(
            SearchModel("Transformer 1","2007","Shia LaBeouf - Megan Fox - Josh Duhamel", R.drawable.transformer1_movie),
            SearchModel("La venganza de los caídos","2009","(Frank Welker - John Turturro - Ramon Rodriguez",R.drawable.transformer2_movie),
            SearchModel("El lado oscuro de la luna","2011","Rosie Huntington-Whiteley - Patrick Dempsey",R.drawable.transformer3_movie),
            SearchModel("La era de la extinción","2014","Mark Wahlberg - John Goodman - Ken Watanabe",R.drawable.transformer4_movie),
            SearchModel("El último caballero","2017","Mark Wahlberg - Akiva Goldsman",R.drawable.transformer5_movie),
            SearchModel("Bumblebee","2018","Hailee Steinfeld - John Cena - Jorge Lendeborg Jr",R.drawable.transformer6_movie)

        )
    }
}