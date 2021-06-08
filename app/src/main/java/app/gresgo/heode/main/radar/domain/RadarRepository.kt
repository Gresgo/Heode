package app.gresgo.heode.main.radar.domain

import app.gresgo.heode.core.model.User

interface RadarRepository {

    suspend fun getNearbyUsers(range: Int): List<User>

}