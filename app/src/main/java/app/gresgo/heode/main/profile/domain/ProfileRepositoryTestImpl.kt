package app.gresgo.heode.main.profile.domain

import app.gresgo.heode.core.model.Profile

class ProfileRepositoryTestImpl: ProfileRepository {

    override suspend fun getProfile(): Profile {
        throw NotImplementedError()
    }

    override suspend fun editProfile(): Profile {
        throw NotImplementedError()
    }

}