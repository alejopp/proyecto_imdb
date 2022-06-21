package com.example.alejobootcampandroid.presentation.ui.home.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.alejobootcampandroid.app.MovieApiStatus
import com.example.alejobootcampandroid.presentation.ui.home.view.adapters.TopRatedMovieAdapter
import com.example.alejobootcampandroid.presentation.ui.home.view.adapters.MovieTrailerAdapter
import com.example.alejobootcampandroid.databinding.FragmentHomeBinding
import com.example.alejobootcampandroid.presentation.ui.home.viewmodel.HomeViewModel
import com.example.alejobootcampandroid.presentation.ui.home.viewmodel.HomeViewModelFactory

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var homeViewModelFactory: HomeViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        homeViewModelFactory = HomeViewModelFactory()
        homeViewModel = ViewModelProvider(this, homeViewModelFactory).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        homeViewModel.getMovieTrailers()
        homeViewModel.movieTrailer.observe(viewLifecycleOwner, Observer { movieTrailers ->
            binding.rvHomeMovieTrailer.also {
                it.adapter = MovieTrailerAdapter(movieTrailers)
            }
        })

        homeViewModel.status.observe(viewLifecycleOwner, Observer { status ->
            when(status){
                MovieApiStatus.LOADING -> binding.ivHomeStatus.visibility = View.VISIBLE
                MovieApiStatus.DONE -> binding.ivHomeStatus.visibility = View.GONE
            }
        })

        homeViewModel.getTopRatedMoviesFromRepository()
        homeViewModel.topRatedMovie.observe(viewLifecycleOwner, Observer { topRatedMovies ->
            binding.rvHomeBestSelected.also {
                it.adapter = TopRatedMovieAdapter(topRatedMovies)
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}