package com.example.alejobootcampandroid.presentation.ui.movie.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alejobootcampandroid.data.movie.MovieModel

class SearchViewModel : ViewModel() {
    private var _movieList = MutableLiveData<ArrayList<MovieModel>>()
    val movieList: LiveData<ArrayList<MovieModel>>
        get() = _movieList
}