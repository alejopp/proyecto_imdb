package com.example.alejobootcampandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_PracticeGroupApplication)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val nav : NavController = findNavController(R.id.nav_host_fragment_activity_search)
    }
}