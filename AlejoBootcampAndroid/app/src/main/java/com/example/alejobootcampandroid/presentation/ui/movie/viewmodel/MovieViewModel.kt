package com.example.alejobootcampandroid.presentation.ui.movie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alejobootcampandroid.data.movie.MovieModel
import com.example.alejobootcampandroid.data.movie.MovieProvider

class MovieViewModel() : ViewModel(){

    private val _movie = MutableLiveData<ArrayList<MovieModel>>()
    val movie: LiveData<ArrayList<MovieModel>>
        get() = _movie

    fun getMovies(){
       val movies = MovieProvider.movieList
       _movie.value = movies
    }

}