package com.example.alejobootcampandroid.receiver

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.presentation.ui.MainActivity
import com.example.alejobootcampandroid.utils.Constants
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class  AlarmReceiver: BroadcastReceiver() {

    companion object{
        const val NOTIFICATION_ID = 1
        const val REQUEST_CODE = 0
        const val TAG = "AlarmReceiver"
    }

    private var imageBitMap: Bitmap? = null

    override fun onReceive(context: Context, intent: Intent) {
        val title = intent.extras?.getString("title")
        val imageUrl = BitmapFactory.decodeResource(context.resources,R.drawable.harry_potter)
        createNotification(context, title, imageUrl)
    }

    private suspend fun getImageBitMap(imageUrl: String?) {
        withContext(Dispatchers.IO){
            imageBitMap = Picasso.get().load("${Constants.BASE_IMAGE_URL}$imageUrl").get()
        }
    }

    private fun createNotification(context: Context, title: String?, imageBitMap: Bitmap?, ){
        val intent = Intent(context, MainActivity::class.java).apply{
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val flag = PendingIntent.FLAG_IMMUTABLE
        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, REQUEST_CODE, intent, flag)

        val notification = NotificationCompat.Builder(context, context.getString(R.string.movie_notification_channel_id))
            .setSmallIcon(R.drawable.ic_movie)
            .setContentTitle(context.getString(R.string.notification_title))
            .setContentText(context.getString(R.string.notification_content_format, title))
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setLargeIcon(imageBitMap)
            .setStyle(NotificationCompat.BigPictureStyle()
                .bigPicture(imageBitMap)
                .bigLargeIcon(null))
            .setAutoCancel(true)
            .build()

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(NOTIFICATION_ID, notification)
    }
}