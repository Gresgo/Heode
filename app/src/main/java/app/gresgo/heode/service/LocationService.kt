package app.gresgo.heode.service

import android.Manifest
import android.annotation.SuppressLint
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
import androidx.preference.PreferenceManager
import app.gresgo.heode.api.HeodeApi
import app.gresgo.heode.model.LocationUpdate
import app.gresgo.heode.model.UserLocation
import app.gresgo.heode.util.BASE_URL
import app.gresgo.heode.util.LOCATION_CHANNEL_ID
import app.gresgo.heode.util.NotificationChannels
import app.gresgo.heode.util.plusAssign
import com.google.android.gms.location.*
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class LocationService: Service() {

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private var name = "mew"
    private lateinit var preferences: SharedPreferences
    private var disposable = CompositeDisposable()

    private lateinit var retrofit: Retrofit
    private lateinit var heodeApi: HeodeApi

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(applicationContext)
        preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        heodeApi = retrofit.create(HeodeApi::class.java)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        name = preferences.getString("name", "mew") ?: "mew"
        setupLocation(10 * 1000L, 10f)
        return START_STICKY
    }

    @SuppressLint("MissingPermission")
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
            val locationTime = point.time / 1000000L

            val geo = UserLocation(
                user = name,
                dots = LocationUpdate(
                    latitude = point.latitude,
                    longitude = point.longitude,
                    accuracy = point.accuracy,
                    speed = if (point.speed == 0.0f) 3f else point.speed,
                    timestamp = locationTime
                )
            )
            disposable += heodeApi.addLocation(geo)
                .subscribeOn(Schedulers.io())
                .subscribe({

                }, {

                })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fusedLocationProviderClient.removeLocationUpdates(locationCallback)
        disposable.dispose()
        stopForeground(true)
    }

}