package app.gresgo.heode.service.ui

import android.location.Location
import app.gresgo.heode.base.ui.BaseViewModel
import app.gresgo.heode.core.model.LocationUpdate
import app.gresgo.heode.service.domain.LocationRepository

class LocationViewModel(
    private val locationRepository: LocationRepository
): BaseViewModel() {

    fun sendLocation(location: Location) {
        launchJob {
            val data = LocationUpdate(
                latitude = location.latitude,
                longitude = location.longitude,
                accuracy = location.accuracy,
                speed = if (location.speed == 0f) 3f else location.speed,
                timestamp = location.time / 1000000L
            )
            locationRepository.sendLocation(data)
        }
    }

}