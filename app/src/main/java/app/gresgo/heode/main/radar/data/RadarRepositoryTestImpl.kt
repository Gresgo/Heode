package app.gresgo.heode.main.radar.data

import app.gresgo.heode.core.model.User

class RadarRepositoryTestImpl: RadarRepository {

    override suspend fun getNearbyUsers(range: Int): List<User> {
        return emptyList()
    }

}