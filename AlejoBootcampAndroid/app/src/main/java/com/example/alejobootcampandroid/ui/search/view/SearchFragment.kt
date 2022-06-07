package com.example.alejobootcampandroid.ui.search.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.alejobootcampandroid.model.Movie
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.databinding.FragmentSearchBinding
import com.example.alejobootcampandroid.ui.search.view.adapters.MovieAdapter
import com.example.alejobootcampandroid.ui.search.viewmodel.SearchViewModel

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    //Recycler variables
    private var recyclerView: RecyclerView? = null
    private var recyclerViewAdapter: MovieAdapter? = null
    private var movieList = mutableListOf<Movie>()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(SearchViewModel::class.java)

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root
        //Add Toolbar
        val toolbar = binding.toolbarSearchFragment
        toolbar.inflateMenu(R.menu.top_bar_menu)

        val searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        searchViewModel.movieList.observe(viewLifecycleOwner, Observer {movie ->
            binding.rvSearchMovies.adapter = MovieAdapter(searchViewModel.movieList as List<Movie>)
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


/*        recyclerView = binding.rvUserOptions
        recyclerViewAdapter = MovieAdapter(movieList)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = recyclerViewAdapter*/

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}