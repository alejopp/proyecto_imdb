package com.example.alejobootcampandroid.presentation.ui.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alejobootcampandroid.app.MovieApiStatus
import com.example.alejobootcampandroid.data.home.MovieTrailerModel
import com.example.alejobootcampandroid.data.home.MovieTrailerProvider
import com.example.alejobootcampandroid.domain.movie.model.TopRatedMovieModel
import com.example.alejobootcampandroid.domain.use_case.movie.GetTopRatedMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTopRatedMovieUseCase: GetTopRatedMovieUseCase
    ) : ViewModel() {

    private val _movieTrailer = MutableLiveData<List<MovieTrailerModel>>()
    val movieTrailer: LiveData<List<MovieTrailerModel>>
        get() = _movieTrailer

    private val _topRatedMovies = MutableLiveData<List<TopRatedMovieModel>>()
    val topRatedMovie: LiveData<List<TopRatedMovieModel>>
        get() = _topRatedMovies

    private val _status = MutableLiveData<MovieApiStatus>()
    val status : LiveData<MovieApiStatus>
        get() = _status

    fun getMovieTrailers(){
        _movieTrailer.value = MovieTrailerProvider.movieTrailerList
    }

    fun getTopRatedMoviesFromRepository(){
        Log.i("INFO","Entro aquí")

        viewModelScope.launch {
            _status.value = MovieApiStatus.LOADING
            try {
                val listResult = getTopRatedMovieUseCase()
                _topRatedMovies.value = listResult.topRatedMoviesList
                _status.value = MovieApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MovieApiStatus.ERROR
            }
        }

    }

}