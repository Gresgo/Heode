package app.gresgo.heode.service.domain

import app.gresgo.heode.core.model.LocationUpdate

interface LocationRepository {

    suspend fun sendLocation(location: LocationUpdate): Boolean

}