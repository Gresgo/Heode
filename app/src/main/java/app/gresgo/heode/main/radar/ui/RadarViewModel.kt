package app.gresgo.heode.main.radar.ui

import app.gresgo.heode.base.ui.BaseViewModel
import app.gresgo.heode.core.model.User
import app.gresgo.heode.main.radar.domain.RadarRepository
import kotlinx.coroutines.flow.MutableStateFlow

class RadarViewModel(
    private val radarRepository: RadarRepository
): BaseViewModel() {

    val users = MutableStateFlow<List<User>>(emptyList())

    init {
        getNearbyUsers()
    }

    fun getNearbyUsers() {
        launchLoadingJob {
            users.value = radarRepository.getNearbyUsers()
        }
    }

}