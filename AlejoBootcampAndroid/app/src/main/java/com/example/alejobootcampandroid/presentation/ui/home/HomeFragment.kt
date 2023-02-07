package com.example.alejobootcampandroid.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.alejobootcampandroid.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        observeViewModel()

        return binding.root
    }

    private fun observeViewModel(){
        homeViewModel.getTopRatedMoviesFromRepository()
        homeViewModel.topRatedMovie.observe(viewLifecycleOwner) { topRatedMovies ->
            if (topRatedMovies != null){
                binding.rvHomeBestSelected.also {
                    it.adapter = TopRatedMovieAdapter(topRatedMovies)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}