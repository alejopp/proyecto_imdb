package com.example.alejobootcampandroid.presentation.ui.search

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.utils.Constants
import com.example.alejobootcampandroid.databinding.FragmentDetailBinding
import com.example.alejobootcampandroid.domain.model.MovieModel
import com.example.alejobootcampandroid.receiver.AlarmReceiver
import com.example.alejobootcampandroid.receiver.AlarmReceiver.Companion.NOTIFICATION_ID
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Calendar

class MovieDetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val movieDetailViewModel: MovieDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        createChannel(
            getString(R.string.movie_notification_channel_id),
            getString(R.string.movie_notification_channel_name)
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Fill screen's elements
        setDataOnScreen()
        listenEvents()
    }

    private fun listenEvents() {
        //Set arrow back event
        binding.toolbarDetail.setOnMenuItemClickListener { arrowBack ->
            onOptionsItemSelected(arrowBack).also {
                findNavController().navigate(R.id.action_detail_to_search)
            }
        }
    }

    private fun setDataOnScreen() {
        // receiving argument from search movie screen
        val movieItem: MovieModel = arguments?.get("movieItem") as MovieModel

        //Set movie title
        binding.tvDetailMovieTitle.text = movieItem.title

        //Set movie original title
        binding.tvDetailOriginalTitle.text =
            "${movieItem.originalTitle} (${getString(R.string.original_title)})"

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

        binding.ivMovieReminder.setOnClickListener {
            Toast.makeText(requireContext(), "Alarm pressed", Toast.LENGTH_LONG).show()
            scheduleNotification(movieItem.title)
        }
    }

    private fun scheduleNotification(title: String) {
        val intent = Intent(context?.applicationContext, AlarmReceiver::class.java).apply {
            putExtra("title", title)
        }
        val pendingIntent = PendingIntent.getBroadcast(
            context?.applicationContext,
            NOTIFICATION_ID,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.setExact(
            AlarmManager.RTC_WAKEUP,
            Calendar.getInstance().timeInMillis + 12000,
            pendingIntent
        )
    }

    private fun createChannel(channelId: String, channelName: String) {
        // TODO: Step 1.6 START create a channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                channelId,
                channelName,
                // TODO: Step 2.4 change importance
                NotificationManager.IMPORTANCE_HIGH
            )
            // TODO: Step 2.6 disable badges for this channel

            notificationChannel.enableLights(true)
            notificationChannel.lightColor = R.color.dark_orange
            notificationChannel.enableVibration(true)
            notificationChannel.description = "Time for watching movies"

            val notificationManager = requireActivity().getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(notificationChannel)

        }
        // TODO: Step 1.6 END create channel
    }

}