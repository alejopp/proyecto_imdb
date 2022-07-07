package com.example.alejobootcampandroid.presentation.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alejobootcampandroid.data.profile.ProfileOptionsModel
import com.example.alejobootcampandroid.data.profile.ProfileOptionsProvider
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor() : ViewModel() {

    companion object{
        const val USERS_COLLECTION = "users"
        const val USER_NAME = "name"
    }

    private val db = FirebaseFirestore.getInstance()

    private val _profileOptions = MutableLiveData<List<ProfileOptionsModel>>()
    val profileOptions: LiveData<List<ProfileOptionsModel>>
        get() = _profileOptions

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String>
        get() = _userName

    fun getProfileOptions(){
        _profileOptions.value = ProfileOptionsProvider.userOptionsList
    }

    fun getUsername(email: String){
        viewModelScope.launch{
            db.collection(USERS_COLLECTION).document(email).get().addOnSuccessListener{
                _userName.value = it.get(USER_NAME) as String?
            }
        }

    }

}