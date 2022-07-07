package com.example.alejobootcampandroid.utils

class UserDataValidation {

    companion object{
         fun isFieldEmpty(data: String): String? {
            var message: String? = null
            if (data.isBlank()){
                message = "El campo es requerido"
            }
            return message
        }
    }
}