package com.example.alejobootcampandroid.presentation.ui.movie.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.app.Constants
import com.example.alejobootcampandroid.databinding.FragmentDetailBinding
import com.example.alejobootcampandroid.databinding.FragmentSearchBinding
import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.squareup.picasso.Picasso

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Fill screen's elements
        setDataOnScreen()
    }

    fun setDataOnScreen(){
        // receiving argument from search movie screen
        val movieItem: MovieModel = arguments?.get("movieItem") as MovieModel

        //Set movie title
        binding.tvDetailMovieTitle.text = movieItem.title

        //Set movie original title
        binding.tvDetailOriginalTitle.text = "${movieItem.original_title} (${getString(R.string.original_title)})"

        //Set release date
        binding.tvDetailMovieYear.text = "${getString(R.string.film_from)} ${movieItem.release_date}"

        // Set image background
        Picasso.get().load("${Constants.BASE_IMAGE_URL}${movieItem.backdrop_path}")
            .into(binding.ivDetailMovieTrailer)

        //Set poster image
        Picasso.get().load("${Constants.BASE_IMAGE_URL}${movieItem.poster_path}")
            .into(binding.ivDetailMovieFrontpage)

        //Set movie score
        binding.tvDetailScore.text = movieItem.vote_average.toString()

        //Set movie overview
        binding.tvDetailMovieDescription.text = movieItem.overview

        //Set number of episodes
        binding.tvDetailEpisodesValue.text = "# Episodes"
    }


}