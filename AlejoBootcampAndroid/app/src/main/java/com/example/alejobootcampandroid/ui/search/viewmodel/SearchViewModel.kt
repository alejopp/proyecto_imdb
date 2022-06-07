package com.example.alejobootcampandroid.ui.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alejobootcampandroid.model.Movie

class SearchViewModel : ViewModel() {
    private var _movieList = MutableLiveData<ArrayList<Movie>>()
    val movieList: LiveData<ArrayList<Movie>>
        get() = _movieList
}