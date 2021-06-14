package app.gresgo.heode.main.team.ui

import app.gresgo.heode.base.ui.BaseViewModel
import app.gresgo.heode.core.model.Request
import app.gresgo.heode.core.model.User
import app.gresgo.heode.main.team.data.TeamRepository
import kotlinx.coroutines.flow.*

class TeamViewModel(
    private val teamRepository: TeamRepository
): BaseViewModel() {

    val teamUsers = MutableStateFlow<List<User>>(arrayListOf())
    val teamRequests = MutableStateFlow<List<Request>>(arrayListOf())

    init {
        loadTeamUsers()
        loadTeamRequests()
    }

    fun loadTeamUsers() {
        launchJob {
            teamUsers.value = teamRepository.getTeamUsers()
        }
    }

    fun loadTeamRequests() {
        launchJob {
            teamRequests.value = teamRepository.getTeamRequests()
        }
    }

    fun removeUser(user: User) {
        launchJob {
            if (teamRepository.removeUser(user.id)) {
                teamUsers.value = teamUsers.value.minus(user)
            } else {
                throw Exception("User removing failed")
            }
        }
    }

    fun acceptRequest(request: Request) {
        launchJob {
            if (teamRepository.acceptRequest(request.id)) {
                teamRequests.value = teamRequests.value.minus(request)
                teamUsers.value = teamUsers.value.plus(request.user)
            } else {
                throw Exception("Failed to accept request")
            }
        }
    }

    fun declineRequest(request: Request) {
        launchJob {
            if (teamRepository.declineRequest(request.id)) {
                teamRequests.value = teamRequests.value.minus(request)
            } else {
                throw Exception("Failed to decline request")
            }
        }
    }

}