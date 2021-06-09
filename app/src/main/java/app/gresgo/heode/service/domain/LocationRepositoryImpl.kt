package app.gresgo.heode.service.domain

import app.gresgo.heode.base.domain.NetworkRepository
import app.gresgo.heode.core.model.LocationUpdate
import app.gresgo.heode.core.network.HeodeApi

class LocationRepositoryImpl(
    private val heodeApi: HeodeApi
): NetworkRepository(), LocationRepository {

    override suspend fun sendLocation(location: LocationUpdate): Boolean {
        val response = heodeApi.addLocation(location)
        return response.isSuccessful
    }

}