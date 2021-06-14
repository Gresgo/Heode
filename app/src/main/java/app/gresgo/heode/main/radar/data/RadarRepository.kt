package app.gresgo.heode.main.radar.data

import app.gresgo.heode.core.model.User

interface RadarRepository {

    suspend fun getNearbyUsers(range: Int = 100): List<User>

}