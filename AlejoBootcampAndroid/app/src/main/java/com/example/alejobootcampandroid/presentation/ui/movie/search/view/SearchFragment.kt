package com.example.alejobootcampandroid.presentation.ui.movie.search.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alejobootcampandroid.data.movie.MovieModel
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.databinding.FragmentSearchBinding
import com.example.alejobootcampandroid.presentation.ui.movie.view.MovieSearchAdapter
import com.example.alejobootcampandroid.presentation.ui.movie.viewmodel.MovieViewModel
import com.example.alejobootcampandroid.presentation.ui.movie.viewmodel.MovieViewModelFactory

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var movieViewModelFactory: MovieViewModelFactory

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    //Recycler variables
    private var recyclerView: RecyclerView? = null
    private var recyclerViewAdapter: MovieSearchAdapter? = null
    private var movieList = mutableListOf<MovieModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //Add Toolbar
        val toolbar = binding.toolbarSearchFragment
        toolbar.inflateMenu(R.menu.top_bar_menu)

        //Set movie recyclerview
        movieViewModelFactory = MovieViewModelFactory()
        movieViewModel = ViewModelProvider(this,movieViewModelFactory).get(MovieViewModel::class.java)
        movieViewModel.getMovies()
        movieViewModel.movie.observe(viewLifecycleOwner, Observer { movies ->
            binding.rvSearchMovies.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.adapter = MovieSearchAdapter(movies)
            }
        })

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}