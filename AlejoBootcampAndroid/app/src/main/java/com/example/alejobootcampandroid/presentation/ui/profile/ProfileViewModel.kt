package com.example.alejobootcampandroid.presentation.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alejobootcampandroid.data.profile.ProfileOptionsModel
import com.example.alejobootcampandroid.data.profile.ProfileOptionsProvider
import com.example.alejobootcampandroid.data.profile.ProfileProvider

class ProfileViewModel : ViewModel() {

    private val _profileOptions = MutableLiveData<List<ProfileOptionsModel>>()
    val profileOptions: LiveData<List<ProfileOptionsModel>>
        get() = _profileOptions

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String>
        get() = _userName

    fun getProfileOptions(){
        _profileOptions.value = ProfileOptionsProvider.userOptionsList
    }

    fun getUsername(){
        _userName.value = ProfileProvider.userList[0].name
    }

}