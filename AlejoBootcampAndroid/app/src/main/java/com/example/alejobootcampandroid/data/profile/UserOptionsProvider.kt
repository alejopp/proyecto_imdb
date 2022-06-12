package com.example.alejobootcampandroid.data.profile

class UserOptionsProvider {
    companion object{
        val userOptionsList = listOf<UserOptionsModel>(
            UserOptionsModel(
                    "Example text",
                    "Calificaciones",
                0
            ),
            UserOptionsModel(
                "Example tex 2",
                "Listas",
                0
            ),
            UserOptionsModel(
                "Example text 3",
                "Comentarios",
                0
            )
        )
    }
}