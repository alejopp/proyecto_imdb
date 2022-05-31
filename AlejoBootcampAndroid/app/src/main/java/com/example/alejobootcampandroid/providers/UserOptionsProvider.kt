package com.example.alejobootcampandroid.providers

import android.content.res.Resources
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.models.UserOptions

class UserOptionsProvider {
    companion object{
        val userOptionsList = listOf<UserOptions>(
            UserOptions(
                    "Example text",
                    "Calificaciones",
                0
            ),
            UserOptions(
                "Example tex 2",
                "Listas",
                0
            ),
            UserOptions(
                "Example text 3",
                "Comentarios",
                0
            )
        )
    }
}