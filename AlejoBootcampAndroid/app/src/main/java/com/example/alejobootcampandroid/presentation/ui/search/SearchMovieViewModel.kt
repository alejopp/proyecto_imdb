package com.example.alejobootcampandroid.presentation.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alejobootcampandroid.data.source.ResponseStatus
import com.example.alejobootcampandroid.domain.model.MovieModel
import com.example.alejobootcampandroid.utils.MovieApiStatus
import com.example.alejobootcampandroid.domain.use_case.movie.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchMovieViewModel @Inject constructor(private val getMoviesUseCase: GetMoviesUseCase) : ViewModel(){

    private val _movies = MutableLiveData<List<MovieModel>?>()
    val movies: LiveData<List<MovieModel>?>
        get() = _movies

    private val _status = MutableLiveData<ResponseStatus<Any>>()
    val status : LiveData<ResponseStatus<Any>>
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
        viewModelScope.launch {
            _status.value = ResponseStatus.Loading()
            val response = getMoviesUseCase(3)
            if (response is ResponseStatus.Success){
                _movies.postValue(response.data)
                _status.value = ResponseStatus.Success(response.data)
            }
            if(response is ResponseStatus.Error){
                _status.postValue(ResponseStatus.Error(response.messageId))
            }
        }
    }

}