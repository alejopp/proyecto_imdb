package com.example.alejobootcampandroid.data.providers

import com.example.alejobootcampandroid.data.model.UserModel

class UserProvider {
    companion object{
        val userList : List<UserModel> = listOf(
            UserModel("Conan","4869"),
            UserModel("naruto","1234")
        )
    }
}