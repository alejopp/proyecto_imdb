package com.example.alejobootcampandroid.presentation.ui.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alejobootcampandroid.databinding.FragmentSearchMovieBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchMovieFragment : Fragment() {

    private var _binding: FragmentSearchMovieBinding? = null
    private val binding get() = _binding!!

    private val searchMovieViewModel: SearchMovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchMovieBinding.inflate(inflater, container, false)
        val root: View = binding.root


        observeViewModel()
        searchMovieViewModel.getMoviesFromRepository()

        return root
    }

    private fun observeViewModel() {
        searchMovieViewModel.movies.observe(viewLifecycleOwner) { movies ->
            binding.rvSearchMovies.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.adapter = movies?.let { movie -> SearchMovieAdapter(movie) }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Set search bar action event
        binding.etvSearchMovie.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                searchMovieViewModel.getMoviesByTitle(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}