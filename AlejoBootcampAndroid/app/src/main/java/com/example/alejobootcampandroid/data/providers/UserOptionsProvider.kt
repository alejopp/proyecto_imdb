package com.example.alejobootcampandroid.providers

import com.example.alejobootcampandroid.model.UserOptions

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