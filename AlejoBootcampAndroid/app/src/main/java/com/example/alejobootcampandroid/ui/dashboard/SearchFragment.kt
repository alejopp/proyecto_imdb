package com.example.alejobootcampandroid.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alejobootcampandroid.ListAdapter
import com.example.alejobootcampandroid.Movie
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null

    //Recycler variables
    private var recyclerView: RecyclerView? = null
    private var recyclerViewAdapter: ListAdapter? = null
    private var movieList = mutableListOf<Movie>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

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
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Recycler
        movieList = ArrayList()
        //recyclerView = findViewById<View>(R.id.rv_movies) as RecyclerView?
        recyclerView = binding.rvUserOptions
        recyclerViewAdapter = ListAdapter(movieList)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = recyclerViewAdapter
        prepareMovie()
    }

    private fun prepareMovie() {
        var movie = Movie("Star Wars The Last Jedi", R.drawable.harry_potter, "2001",getString(R.string.default_star))
        movieList.add(movie)
        movie = Movie("Coco", R.drawable.harry_potter,"2001",getString(R.string.default_star))
        movieList.add(movie)
        movie = Movie("Justice League", R.drawable.harry_potter,"2001",getString(R.string.default_star))
        movieList.add(movie)
        movie = Movie("Thor: Ragnarok", R.drawable.harry_potter, "2001",getString(R.string.default_star))
        movieList.add(movie)
        movie = Movie("Star Wars The Last Jedi", R.drawable.harry_potter, "2001",getString(R.string.default_star))
        movieList.add(movie)
        movie = Movie("Coco", R.drawable.harry_potter,"2001",getString(R.string.default_star))
        movieList.add(movie)
        movie = Movie("Justice League", R.drawable.harry_potter,"2001",getString(R.string.default_star))
        movieList.add(movie)

        recyclerViewAdapter?.notifyDataSetChanged()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}