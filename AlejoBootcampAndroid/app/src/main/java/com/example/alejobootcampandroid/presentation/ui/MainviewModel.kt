package com.example.alejobootcampandroid.presentation.ui

/*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alejobootcampandroid.domain.service.ConfigService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val configService: ConfigService): ViewModel() {

    var _defaultLanguage = MutableLiveData<String>()
    val defaultLanguage: LiveData<String> get() = _defaultLanguage

    init {
        viewModelScope.launch {
            configService.fetchConfiguration()
            _defaultLanguage.postValue(configService.defaultLanguage)
        }
    }
}*/
