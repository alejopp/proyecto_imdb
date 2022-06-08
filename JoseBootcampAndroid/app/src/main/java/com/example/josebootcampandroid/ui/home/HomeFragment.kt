package com.example.josebootcampandroid.ui.home

import android.graphics.Movie
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.josebootcampandroid.adapter.ActionAdapter
import com.example.josebootcampandroid.adapter.ListMovieAdapter
import com.example.josebootcampandroid.adapter.MovieProfileAdapater
import com.example.josebootcampandroid.databinding.FragmentHomeBinding
import com.example.josebootcampandroid.model.MovieProfile
import com.example.josebootcampandroid.provider.ActionProvider
import com.example.josebootcampandroid.provider.ListMovieProvider
import com.example.josebootcampandroid.provider.MovieProfileProvider

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageMovieProfile = binding.rvimageMovieProfile
        imageMovieProfile.adapter = MovieProfileAdapater(MovieProfileProvider.listMovieProfile)
        val imageListMovie = binding.rvLasMejores
        imageListMovie.adapter = ListMovieAdapter(ListMovieProvider.listMovieProfile)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}