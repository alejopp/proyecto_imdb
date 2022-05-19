package com.example.alejobootcampandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_PracticeGroupApplication)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}