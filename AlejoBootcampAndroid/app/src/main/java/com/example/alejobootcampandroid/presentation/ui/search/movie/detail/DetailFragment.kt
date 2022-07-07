package com.example.alejobootcampandroid.presentation.ui.search.movie.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.utils.Constants
import com.example.alejobootcampandroid.databinding.FragmentDetailBinding
import com.example.alejobootcampandroid.domain.movie.model.MovieModel
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Fill screen's elements
        setDataOnScreen()
        listeners()

    }

    fun listeners(){
        //Set arrow back event
        binding.toolbarDetail.setOnMenuItemClickListener{ arrowBack ->
            onOptionsItemSelected(arrowBack).also {
                findNavController().navigate(R.id.action_detail_to_search)
            }
        }
    }

    private fun setDataOnScreen(){
        // receiving argument from search movie screen
       val movieItem: MovieModel = arguments?.get("movieItem") as MovieModel

        //Set movie title
        binding.tvDetailMovieTitle.text = movieItem.title

        //Set movie original title
        binding.tvDetailOriginalTitle.text = "${movieItem.originalTitle} (${getString(R.string.original_title)})"

        //Set release date
        binding.tvDetailMovieYear.text = "${getString(R.string.film_from)} ${movieItem.releaseDate}"

        // Set image background
        Picasso.get().load("${Constants.BASE_IMAGE_URL}${movieItem.backgroundImage}")
            .into(binding.ivDetailMovieTrailer)

        //Set poster image
        Picasso.get().load("${Constants.BASE_IMAGE_URL}${movieItem.posterImage}")
            .into(binding.ivDetailMovieFrontpage)

        //Set movie score
        binding.tvDetailScore.text = movieItem.scoreAverage.toString()

        //Set movie overview
        binding.tvDetailMovieDescription.text = movieItem.overview

        //Set text in toolbar
        binding.tvDetailMovieSearchbar.text = movieItem.title

        binding.btDetailCategory.text = movieItem.genre

    }


}