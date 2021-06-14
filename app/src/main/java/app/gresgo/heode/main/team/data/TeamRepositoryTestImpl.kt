package app.gresgo.heode.main.team.data

import app.gresgo.heode.core.model.Request
import app.gresgo.heode.core.model.User
import app.gresgo.heode.core.model.UserLocation
import kotlinx.coroutines.delay

class TeamRepositoryTestImpl: TeamRepository {

    override suspend fun getTeamUsers(): List<User> {
        delay(1000)
        return listOf(
            User(
                id = 1,
                name = "Sally Jake",
                avatar = "",
                location = UserLocation(56.817721, 60.546730)
            ),
            User(
                id = 2,
                name = "Abbeth Fergenes",
                avatar = "",
                location = UserLocation(56.825977, 60.560921)
            ),
            User(
                id = 3,
                name = "Noel Simon",
                avatar = "",
                location = UserLocation(56.831404, 60.610671)
            ),
            User(
                id = 4,
                name = "Fred Olsen",
                avatar = "",
                location = UserLocation(56.849034, 60.643041)
            ),
            User(
                id = 5,
                name = "Gresgo",
                avatar = "",
                location = UserLocation(56.892868, 60.742622)
            )
        )
    }

    override suspend fun getTeamRequests(): List<Request> {
        return listOf(
            Request(
                id = 111,
                user = User(
                    id = 111,
                    name = "Creamy Pie",
                    avatar = "",
                    location = UserLocation(56.905834, 60.799813)
                )
            ),
            Request(
                id = 112,
                user = User(
                    id = 112,
                    name = "Mike Jordan",
                    avatar = "",
                    location = UserLocation(56.803864, 60.594594)
                )
            )
        )
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