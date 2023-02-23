package com.example.alejobootcampandroid.presentation.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavArgument
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.SplashViewModel
import com.example.alejobootcampandroid.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val splashViewModel: SplashViewModel by viewModels()
    private var withJetpackCompose: Boolean? = null

    companion object{
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeViewModel()
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_search)
        navView.setupWithNavController(navController)
        this.deleteDatabase("movie_database")
    }

    private fun observeViewModel() {
        splashViewModel.withJetpackCompose.observe(this){
            withJetpackCompose = it
        }
    }

}


