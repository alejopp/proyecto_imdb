package com.example.josebootcampandroid.data.profile

class ActionProvider {
    companion object{
        val listComments = listOf<ActionsModel>(
            ActionsModel("Calificar y obtener recomendaciones","Calificaciones","0"),
            ActionsModel("Agregar a lista","Listas","4"),
            ActionsModel("Aun no se tiene comentarios","Comentarios","0")
        )
    }
}