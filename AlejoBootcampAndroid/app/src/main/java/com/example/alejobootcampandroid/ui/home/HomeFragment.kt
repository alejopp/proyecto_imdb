package com.example.alejobootcampandroid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.alejobootcampandroid.adapters.BestSelectionAdapter
import com.example.alejobootcampandroid.adapters.MovieTrailerAdapter
import com.example.alejobootcampandroid.databinding.FragmentHomeBinding
import com.example.alejobootcampandroid.providers.BestSelectionProvider
import com.example.alejobootcampandroid.providers.MovieTrailerProvider

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Filling RecycleViews
        val rvBestSelected = binding.rvHomeBestSelected
        rvBestSelected.adapter = BestSelectionAdapter(BestSelectionProvider.bestSelectionList)

        val rvMovieTrailer = binding.rvHomeMovieTrailer
        rvMovieTrailer.adapter = MovieTrailerAdapter(MovieTrailerProvider.movieTrailerList)
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rvMovieTrailer)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}