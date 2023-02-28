package com.example.alejobootcampandroid.utils

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.presentation.ui.MainActivity

private val NOTIFICATION_ID = 0
private val REQUEST_CODE = 0
private val FLAGS = PendingIntent.FLAG_ONE_SHOT

fun NotificationManager.sendNotification(messageBody: String, applicationContext: Context) {
    // Create the content intent for the notification, which launches
    // this activity
/*    val contentIntent = Intent(applicationContext, MainActivity::class.java)
    val contentPendingIntent = PendingIntent.getActivity(
        applicationContext,
        NOTIFICATION_ID,
        contentIntent,
        PendingIntent.FLAG_UPDATE_CURRENT
    )*/
    // TODO: Step 2.0 add style

    // TODO: Step 2.2 add snooze action

    // TODO: Step 1.2 get an instance of NotificationCompat.Builder
    // Build the notification
    val builder = NotificationCompat.Builder(
        applicationContext,
        applicationContext.getString(R.string.movie_notification_channel_id)
    )

        // TODO: Step 1.8 use the new 'breakfast' notification channel

        // TODO: Step 1.3 set title, text and icon to builder
        .setSmallIcon(R.drawable.ic_movie)
        .setContentTitle(applicationContext.getString(R.string.notification_title))
        .setContentText(messageBody)

        // TODO: Step 1.13 set content intent
/*        .setContentIntent(contentPendingIntent)
        .setAutoCancel(true)*/

        // TODO: Step 2.1 add style to builder

        // TODO: Step 2.3 add snooze action

        // TODO: Step 2.5 set priority
        //.setPriority(NotificationCompat.PRIORITY_LOW)

    // TODO: Step 1.4 call notify
    notify(NOTIFICATION_ID, builder.build())


}

// TODO: Step 1.14 Cancel all notifications
fun NotificationManager.cancelNotifications() {
    cancelAll()
}