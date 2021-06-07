package app.gresgo.heode.service

import android.Manifest
import android.app.Notification
import android.app.Service
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Build
import android.os.IBinder
import android.os.Looper
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import app.gresgo.heode.core.model.LocationUpdate
import app.gresgo.heode.core.model.UserLocation
import app.gresgo.heode.utils.LOCATION_CHANNEL_ID
import app.gresgo.heode.utils.NotificationChannels
import com.google.android.gms.location.*

class LocationService: Service() {

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(applicationContext)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        setupLocation(10 * 1000L, 10f)
        return START_STICKY
    }

    private fun setupLocation(minTime: Long, minDistance: Float) {
        if (ActivityCompat.checkSelfPermission(
                applicationContext,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED) return

        val locationRequest = LocationRequest.create().apply {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            interval = minTime
            smallestDisplacement = minDistance
        }

        fusedLocationProviderClient.removeLocationUpdates(locationCallback)
        fusedLocationProviderClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper()
        )

        NotificationChannels.createLocationChannel(applicationContext)
        val notification = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification.Builder(applicationContext, LOCATION_CHANNEL_ID)
                .build()
        } else {
            NotificationCompat.Builder(applicationContext)
                .setPriority(NotificationCompat.PRIORITY_MIN)
                .build()
        }
        startForeground(1, notification)
    }

    private val locationCallback = object : LocationCallback() {
        override fun onLocationResult(location: LocationResult) {
            val point = location.lastLocation
            // TODO: fix location time
            val locationTime = point.time / 1000000L

            val geo = LocationUpdate(
                latitude = point.latitude,
                longitude = point.longitude,
                accuracy = point.accuracy,
                speed = if (point.speed == 0.0f) 3f else point.speed,
                timestamp = locationTime
            )

            // TODO: send location
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fusedLocationProviderClient.removeLocationUpdates(locationCallback)
        stopForeground(true)
    }

}