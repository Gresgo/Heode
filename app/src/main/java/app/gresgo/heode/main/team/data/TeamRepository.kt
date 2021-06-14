package app.gresgo.heode.main.team.data

import app.gresgo.heode.core.model.Request
import app.gresgo.heode.core.model.User

interface TeamRepository {

    suspend fun getTeamUsers(): List<User>

    suspend fun getTeamRequests(): List<Request>

    suspend fun removeUser(userId: Int): Boolean

    suspend fun acceptRequest(requestId: Int): Boolean

    suspend fun declineRequest(requestId: Int): Boolean

}