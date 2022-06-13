package com.example.alejobootcampandroid.presentation.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alejobootcampandroid.data.home.BestSelectionModel
import com.example.alejobootcampandroid.data.home.BestSelectionProvider
import com.example.alejobootcampandroid.data.home.MovieTrailerModel
import com.example.alejobootcampandroid.data.home.MovieTrailerProvider

class HomeViewModel : ViewModel() {

    private val _movieTrailer = MutableLiveData<List<MovieTrailerModel>>()
    val movieTrailer: LiveData<List<MovieTrailerModel>>
        get() = _movieTrailer

    private val _movieBestSelection = MutableLiveData<List<BestSelectionModel>>()
    val movieBestSelection: LiveData<List<BestSelectionModel>>
        get() = _movieBestSelection

    fun getMovieTrailers(){
        _movieTrailer.value = MovieTrailerProvider.movieTrailerList
    }

    fun getBestSelections(){
        _movieBestSelection.value = BestSelectionProvider.bestSelectionList
    }
}