package com.example.alejobootcampandroid.data.repository

import com.example.alejobootcampandroid.domain.model.ProfileOptionsModel

class UserRepositoryImpl {
    companion object{
        val userOptionsList = listOf(
            ProfileOptionsModel(
                "Calificar y obtener recomendaciones",
                "Calificaciones",
                0
            ),
            ProfileOptionsModel(
                "Agregar a listas",
                "Listas",
                0
            ),
            ProfileOptionsModel(
                "Aun no tienes comentarios",
                "Comentarios",
                0
            )
        )
    }
}