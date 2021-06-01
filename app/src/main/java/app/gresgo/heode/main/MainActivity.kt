package app.gresgo.heode.main

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.preference.PreferenceManager
import app.gresgo.heode.databinding.ActivityMainBinding
import app.gresgo.heode.service.LocationService

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkPermissions()

        val preferences = PreferenceManager.getDefaultSharedPreferences(this.applicationContext)
        val service = Intent(this, LocationService::class.java)

        binding.name.setText(preferences.getString("name", "") ?: "")

        binding.nameUpdate.setOnClickListener {
            if (checkName()) {
                preferences.edit()
                        .putString("name", binding.name.text.toString())
                        .apply()
            }
        }

        binding.locationStart.setOnClickListener {
            if (checkName() && checkPermissions()) {
                startService(service)
            }
        }

        binding.locationStop.setOnClickListener {
            stopService(service)
        }


    }

    private fun checkPermissions(): Boolean {
        return if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                777
            )
            false
        } else true
    }

    private fun checkName(): Boolean {
        return if (binding.name.text.isNullOrEmpty()) {
            Toast.makeText(this, "Name is not set", Toast.LENGTH_SHORT).show()
            false
        } else {
            true
        }
    }
}