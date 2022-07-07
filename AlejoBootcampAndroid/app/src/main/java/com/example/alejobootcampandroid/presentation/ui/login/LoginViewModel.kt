package com.example.alejobootcampandroid.presentation.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alejobootcampandroid.utils.Constants.MESSAGE
import com.example.alejobootcampandroid.utils.Constants.TITLE
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    private var _messages = MutableLiveData<HashMap<String,String>>()
    val messages: LiveData<HashMap<String, String>>
        get() = _messages

    fun signIn(email: String, password: String ){
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    _messages.postValue(hashMapOf(TITLE to "Success", MESSAGE to "ok"))
                }
                else{
                    _messages.postValue(hashMapOf(TITLE to "Error", MESSAGE to "Wrong email or password"))
                }
            }
    }
}