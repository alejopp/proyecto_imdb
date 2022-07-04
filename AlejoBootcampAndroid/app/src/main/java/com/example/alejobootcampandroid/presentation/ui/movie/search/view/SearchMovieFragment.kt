package com.example.alejobootcampandroid.presentation.ui.movie.search.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.app.MovieApiStatus
import com.example.alejobootcampandroid.databinding.FragmentSearchMovieBinding
import com.example.alejobootcampandroid.presentation.ui.movie.view.MovieSearchAdapter
import com.example.alejobootcampandroid.presentation.ui.movie.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchMovieFragment : Fragment() {

    private var _binding: FragmentSearchMovieBinding? = null
    private val movieViewModel: MovieViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchMovieBinding.inflate(inflater, container, false)
        val root: View = binding.root
        
        movieViewModel.getMoviesFromRepository()
        movieViewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            binding.rvSearchMovies.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.adapter = MovieSearchAdapter(movies)
            }
        })

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Set search bar action event
        binding.etvSearchMovie.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                movieViewModel.getMoviesByTitle(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}