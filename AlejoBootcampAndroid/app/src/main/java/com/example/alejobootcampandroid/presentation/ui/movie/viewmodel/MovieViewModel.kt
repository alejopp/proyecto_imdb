package com.example.alejobootcampandroid.presentation.ui.movie.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alejobootcampandroid.data.movie.Movie
import com.example.alejobootcampandroid.data.movie.MovieProvider

class MovieViewModel() : ViewModel(){

    private val _movie = MutableLiveData<ArrayList<Movie>>()
    val movie: LiveData<ArrayList<Movie>>
        get() = _movie

    fun getMovies(){
       val movies = MovieProvider.movieList
       _movie.value = movies
    }

}