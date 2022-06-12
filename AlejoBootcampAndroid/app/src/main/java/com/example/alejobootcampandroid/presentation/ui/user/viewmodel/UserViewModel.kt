package com.example.alejobootcampandroid.presentation.ui.user.viewmodel

import androidx.lifecycle.ViewModel
import com.example.alejobootcampandroid.data.profile.UserModel

class UserViewModel : ViewModel() {

    // val userModel = MutableLiveData<UserModel>()
    private var user: UserModel? = null

    fun getUser(userName: String, password: String): UserModel {
         user = UserModel(userName,password)
        return user as UserModel
    }

}