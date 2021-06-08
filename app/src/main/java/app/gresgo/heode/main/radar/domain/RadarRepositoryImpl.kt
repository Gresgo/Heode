package app.gresgo.heode.main.radar.domain

import app.gresgo.heode.base.domain.NetworkRepository
import app.gresgo.heode.core.model.User
import app.gresgo.heode.core.network.HeodeApi

class RadarRepositoryImpl(
    private val heodeApi: HeodeApi
): NetworkRepository(), RadarRepository {

    override suspend fun getNearbyUsers(range: Int): List<User> {
        return emptyList()
    }

}