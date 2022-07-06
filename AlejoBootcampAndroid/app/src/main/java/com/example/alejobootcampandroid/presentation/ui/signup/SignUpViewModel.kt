package com.example.alejobootcampandroid.presentation.ui.signup

import androidx.lifecycle.ViewModel

class SignUpViewModel: ViewModel() {
    val db = FireBaseFi

    fun signUp(userName:String, email: String, userPassword: String){
        if(!email.isNullOrEmpty() && !userPassword.isNullOrEmpty()){
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email,userPassword)
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        saveInFirestore(userName,email)
                    }
                }
        }
    }
}