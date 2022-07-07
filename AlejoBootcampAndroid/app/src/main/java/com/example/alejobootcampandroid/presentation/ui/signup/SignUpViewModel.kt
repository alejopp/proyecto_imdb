package com.example.alejobootcampandroid.presentation.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alejobootcampandroid.utils.Constants.EMAIL
import com.example.alejobootcampandroid.utils.Constants.MESSAGE
import com.example.alejobootcampandroid.utils.Constants.NAME
import com.example.alejobootcampandroid.utils.Constants.TITLE
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor() : ViewModel() {

    private val db = FirebaseFirestore.getInstance()

    private var _messages = MutableLiveData<HashMap<String,String>>()
    val messages: LiveData<HashMap<String,String>>
        get() = _messages

    fun signUp(userName: String, email: String, userPassword: String) {
        viewModelScope.launch {
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, userPassword)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        saveInFirestore(userName, email)
                        _messages.postValue(hashMapOf(TITLE to "Success", MESSAGE to "User registered correctly"))
                    }else{
                        _messages.postValue(hashMapOf(TITLE to "Error", MESSAGE to "User cannot be registered"))
                    }
                }
        }
    }

    private fun saveInFirestore(userName: String, userEmail: String) {
        db.collection("users").document(userEmail).set(
            hashMapOf(NAME to userName, EMAIL to userEmail)
        )
    }
}