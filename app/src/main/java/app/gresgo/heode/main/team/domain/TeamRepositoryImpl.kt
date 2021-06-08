package app.gresgo.heode.main.team.domain

import app.gresgo.heode.base.domain.NetworkRepository
import app.gresgo.heode.core.model.Request
import app.gresgo.heode.core.model.User
import app.gresgo.heode.core.network.HeodeApi
import kotlinx.coroutines.delay

class TeamRepositoryImpl(
    private val heodeApi: HeodeApi
): NetworkRepository(), TeamRepository {

    override suspend fun getTeamUsers(): List<User> {
        return emptyList()
    }

    override suspend fun getTeamRequests(): List<Request> {
        return emptyList()
    }

    override suspend fun removeUser(userId: Int): Boolean {
        delay(100)
        return true
    }

    override suspend fun acceptRequest(requestId: Int): Boolean {
        delay(100)
        return true
    }

    override suspend fun declineRequest(requestId: Int): Boolean {
        delay(100)
        return true
    }

}