package com.example.alejobootcampandroid.presentation.ui.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.SplashViewModel
import com.example.alejobootcampandroid.databinding.FragmentSearchMovieBinding
import com.example.alejobootcampandroid.databinding.FragmentSearchMovieComposeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchMovieFragment : Fragment() {

    private var _binding: FragmentSearchMovieBinding? = null
    private val binding get() = _binding!!

    private var _bindingCompose: FragmentSearchMovieComposeBinding? = null
    private val bindingCompose get() = _bindingCompose!!

    private val searchMovieViewModel: SearchMovieViewModel by viewModels()
    private val splashViewModel: SplashViewModel by viewModels()

    companion object {
        const val TAG = "SearchMovieFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchMovieBinding.inflate(inflater, container, false)
        observeViewModel()
        searchMovieViewModel.getMoviesFromRepository()
        //TODO apply conditional compose
/*        binding.composeView.apply {
            setViewCompositionStrategy(
                ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
            )
            // Add Jetpack Compose content to this View
            setContent {
                AlejoBootcampAndroidAppTheme {
                    SearchMovieScreen { showMovieDetail() }
                }
            }
        }*/
        return binding.root
    }

    private fun showMovieDetail() {
        findNavController().navigate(R.id.navigation_detail)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Set search bar action event
        binding.etvSearchMovie.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?, start: Int, count: Int, after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                searchMovieViewModel.getMoviesByTitle(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun observeViewModel() {
        searchMovieViewModel.movies.observe(viewLifecycleOwner) { movies ->
            binding.rvSearchMovies.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.adapter = movies?.let { movie -> SearchMovieAdapter(movie) }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}