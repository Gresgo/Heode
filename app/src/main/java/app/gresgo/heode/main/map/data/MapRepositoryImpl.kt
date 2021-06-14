package app.gresgo.heode.main.map.data

import app.gresgo.heode.base.domain.NetworkRepository
import app.gresgo.heode.core.network.HeodeApi

class MapRepositoryImpl(
    private val heodeApi: HeodeApi
): NetworkRepository(), MapRepository {
}