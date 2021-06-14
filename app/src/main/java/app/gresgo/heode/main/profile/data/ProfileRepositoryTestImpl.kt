package app.gresgo.heode.main.profile.data

import app.gresgo.heode.core.model.Profile
import kotlinx.coroutines.delay

class ProfileRepositoryTestImpl: ProfileRepository {

    override suspend fun getProfile(): Profile {
        delay(100)
        return Profile(
            name = "James Bond",
            avatar = "",
            email = "jamesbond@gmail.com"
        )
    }

    override suspend fun editProfile(name: String): Profile {
        delay(100)
        return Profile(
            name = name,
            avatar = "",
            email = "jamesbond@gmail.com"
        )
    }

}