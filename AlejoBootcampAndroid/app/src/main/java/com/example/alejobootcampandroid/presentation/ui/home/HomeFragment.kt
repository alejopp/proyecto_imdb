package com.example.alejobootcampandroid.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.alejobootcampandroid.utils.Constants.APP_TITLE
import com.example.alejobootcampandroid.databinding.FragmentHomeBinding
import com.example.alejobootcampandroid.presentation.ui.home.adapters.TopRatedMovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        //Add Toolbar
        val toolbar = binding.tbHomeAppTitle
        toolbar.title = APP_TITLE

        observers()
        listeners()

        return binding.root
    }

    private fun listeners() {
        binding.sbHomeSwitchTheme.setOnCheckedChangeListener{ _, isChecked ->
            if(isChecked){
                Toast.makeText(context, "night", Toast.LENGTH_LONG).show()
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
            }
            else{
                Toast.makeText(context, "day", Toast.LENGTH_LONG).show()
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
            }
        }
    }

    fun observers(){
        homeViewModel.getTopRatedMoviesFromRepository()
        homeViewModel.topRatedMovie.observe(viewLifecycleOwner) { topRatedMovies ->
            binding.rvHomeBestSelected.also {
                it.adapter = TopRatedMovieAdapter(topRatedMovies)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}