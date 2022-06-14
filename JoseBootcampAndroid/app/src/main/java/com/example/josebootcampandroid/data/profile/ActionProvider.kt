package com.example.josebootcampandroid.data.profile

class ActionProvider {
    companion object{
        val listComments = listOf<Actions>(
            Actions("Calificar y obtener recomendaciones","Calificaciones","0"),
            Actions("Agregar a lista","Listas","4"),
            Actions("Aun no se tiene comentarios","Comentarios","0")
        )
    }
}