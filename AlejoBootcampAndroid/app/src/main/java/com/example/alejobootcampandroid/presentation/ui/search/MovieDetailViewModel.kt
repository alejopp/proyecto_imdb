package com.example.alejobootcampandroid.presentation.ui.search

import android.app.AlarmManager
import android.app.Application
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.CountDownTimer
import android.os.SystemClock
import androidx.core.app.AlarmManagerCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.*
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.receiver.AlarmReceiver
import com.example.alejobootcampandroid.utils.sendNotification
import dagger.hilt.android.internal.Contexts.getApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.Duration
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val app: Application): AndroidViewModel(app) {


}