package com.example.alejobootcampandroid.presentation.ui.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alejobootcampandroid.data.home.MovieTrailerModel
import com.example.alejobootcampandroid.data.home.MovieTrailerProvider
import com.example.alejobootcampandroid.domain.movie.model.TopRatedMovieModel
import com.example.alejobootcampandroid.domain.use_case.movie.GetTopRatedMovieUseCase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _movieTrailer = MutableLiveData<List<MovieTrailerModel>>()
    val movieTrailer: LiveData<List<MovieTrailerModel>>
        get() = _movieTrailer

    private val _topRatedMovies = MutableLiveData<List<TopRatedMovieModel>>()
    val topRatedMovie: LiveData<List<TopRatedMovieModel>>
        get() = _topRatedMovies

    private val getTopRatedMovieUseCase = GetTopRatedMovieUseCase()

    private val _status = MutableLiveData<String>()
    val status : LiveData<String>
        get() = _status

    fun getMovieTrailers(){
        _movieTrailer.value = MovieTrailerProvider.movieTrailerList
    }

    fun getTopRatedMoviesFromRepository(){
        Log.i("INFO","Entro aquí")

        viewModelScope.launch {
            try {
                val listResult = getTopRatedMovieUseCase()
                _topRatedMovies.value = listResult.topRatedMoviesList
            } catch (e: Exception) {
                _status.value = e.message
            }
        }

    }

}