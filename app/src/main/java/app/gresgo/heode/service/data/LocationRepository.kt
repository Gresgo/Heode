package app.gresgo.heode.service.data

import app.gresgo.heode.core.model.LocationUpdate

interface LocationRepository {

    suspend fun sendLocation(location: LocationUpdate): Boolean

}