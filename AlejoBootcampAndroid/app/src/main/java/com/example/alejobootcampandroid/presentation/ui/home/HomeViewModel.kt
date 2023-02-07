package com.example.alejobootcampandroid.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alejobootcampandroid.data.source.ResponseStatus
import com.example.alejobootcampandroid.domain.model.TopRatedMovieModel
import com.example.alejobootcampandroid.domain.use_case.movie.GetTopRatedMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTopRatedMovieUseCase: GetTopRatedMovieUseCase
    ) : ViewModel() {

    private val _topRatedMovies = MutableLiveData<List<TopRatedMovieModel>?>()
    val topRatedMovie: LiveData<List<TopRatedMovieModel>?>
        get() = _topRatedMovies

    fun getTopRatedMoviesFromRepository(){
        viewModelScope.launch {
            val response = getTopRatedMovieUseCase()
            if(response is ResponseStatus.Success){
                _topRatedMovies.postValue(response.data)
            }
        }
    }

}