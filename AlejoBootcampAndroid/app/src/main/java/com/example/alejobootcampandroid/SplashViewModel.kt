package com.example.alejobootcampandroid

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alejobootcampandroid.domain.service.ConfigService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val configService: ConfigService): ViewModel() {

    companion object{
        const val TAG = "SplashViewModel"
    }

    private var _withJetpackCompose = MutableLiveData<Boolean>()
        val withJetpackCompose: LiveData<Boolean> get() = _withJetpackCompose

    init {
        Log.d(TAG, "Splash view model created")
        viewModelScope.launch {
            configService.fetchConfiguration()
            _withJetpackCompose.postValue(configService.withJetpackCompose)
        }
    }
}