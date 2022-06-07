package com.example.alejobootcampandroid.ui.user.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alejobootcampandroid.data.model.UserModel
import com.example.alejobootcampandroid.data.providers.UserProvider

class UserViewModel : ViewModel() {

    // val userModel = MutableLiveData<UserModel>()
    private var user: UserModel? = null

    fun getUser(userName: String, password: String): UserModel{
         user = UserModel(userName,password)
        return user as UserModel
    }

}