package app.gresgo.heode.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

object NotificationChannels {

    fun createLocationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = context.getSystemService(
                Context.NOTIFICATION_SERVICE
            ) as NotificationManager
            val channel = NotificationChannel(
                LOCATION_CHANNEL_ID,
                "Location udapte",
                NotificationManager.IMPORTANCE_NONE
            )
            notificationManager.createNotificationChannel(channel)
        }
    }

}