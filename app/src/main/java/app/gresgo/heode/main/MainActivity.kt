package app.gresgo.heode.main

import android.Manifest
import android.content.SharedPreferences
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import app.gresgo.heode.R
import app.gresgo.heode.databinding.ActivityMainBinding
import app.gresgo.heode.main.team.ui.TeamViewModel
import app.gresgo.heode.utils.PreferenceKeys
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.flow.collect
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener {

    private lateinit var binding: ActivityMainBinding
    private val preferences: SharedPreferences by inject()
    private var gMap: GoogleMap? = null
    private val teamViewModel: TeamViewModel by viewModel()

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
            createMap()
        }
        controller.graph = graph
//        checkPermissions()
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {

    }

    private fun createMap() {
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync { map ->
            gMap = map
            lifecycleScope.launchWhenCreated {
                teamViewModel.teamUsers.collect { users ->
                    map.clear()
                    if (users.isNullOrEmpty()) return@collect
                    val bounds = LatLngBounds.Builder()
                    users.forEach {
                        it.location?.let { location ->
                            val position = LatLng(location.latitude, location.longitude)
                            val marker = MarkerOptions()
                                .position(position)
                                .title(it.name)
                            bounds.include(position)
                            map.addMarker(marker)
                        }
                    }
                    map.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds.build(), 200))
                }
            }
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
}