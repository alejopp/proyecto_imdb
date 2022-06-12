package com.example.alejobootcampandroid.presentation.ui.movie.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alejobootcampandroid.data.movie.Movie

class SearchViewModel : ViewModel() {
    private var _movieList = MutableLiveData<ArrayList<Movie>>()
    val movieList: LiveData<ArrayList<Movie>>
        get() = _movieList
}