package app.gresgo.heode.main

import android.Manifest
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.view.WindowCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.preference.PreferenceManager
import app.gresgo.heode.R
import app.gresgo.heode.databinding.ActivityMainBinding
import app.gresgo.heode.service.LocationService
import app.gresgo.heode.utils.PreferenceKeys
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener {

    private lateinit var binding: ActivityMainBinding
    private val preferences: SharedPreferences by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.host) as NavHostFragment
        val controller = navHostFragment.navController
        val graph = controller.navInflater.inflate(R.navigation.main)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        preferences.registerOnSharedPreferenceChangeListener(this)
        if (preferences.getString(PreferenceKeys.TOKEN, null) == null) {
            graph.startDestination = R.id.login
        } else {
//            createMap()
        }
        controller.graph = graph
//        checkPermissions()
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {

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
}