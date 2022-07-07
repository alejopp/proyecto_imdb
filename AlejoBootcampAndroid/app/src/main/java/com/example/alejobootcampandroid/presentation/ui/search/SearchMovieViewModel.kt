package com.example.alejobootcampandroid.presentation.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alejobootcampandroid.utils.MovieApiStatus
import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.example.alejobootcampandroid.domain.use_case.movie.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchMovieViewModel @Inject constructor(private val getMoviesUseCase: GetMoviesUseCase) : ViewModel(){

    private val _movies = MutableLiveData<List<MovieModel>>()
    val movies: LiveData<List<MovieModel>>
        get() = _movies

    private val _status = MutableLiveData<MovieApiStatus>()
    val status : LiveData<MovieApiStatus>
        get() = _status

    private var moviesCopy = emptyList<MovieModel>()

    fun getMoviesByTitle(movieQuery: String){

        if (movieQuery.isNotEmpty()){
            _movies.value = moviesCopy.filter { movie ->
                movie.title.lowercase().contains(movieQuery.lowercase())
            }
        }
        else{
            _movies.postValue(moviesCopy)
        }

    }

    fun getMoviesFromRepository(){
        _status.value = MovieApiStatus.LOADING
        viewModelScope.launch {
            try {
                val listResult = getMoviesUseCase(3)
                _movies.value = listResult
                moviesCopy = listResult
                _status.value = MovieApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MovieApiStatus.ERROR
                _movies.value = listOf()
            }
        }
    }


}