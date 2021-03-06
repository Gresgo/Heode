package app.gresgo.heode.main.profile.data

import app.gresgo.heode.base.domain.NetworkRepository
import app.gresgo.heode.core.model.Profile
import app.gresgo.heode.core.network.HeodeApi

class ProfileRepositoryImpl(
    private val heodeApi: HeodeApi
): NetworkRepository(), ProfileRepository {

    override suspend fun getProfile(): Profile {
        return heodeApi.getProfile().getResponseBody()
    }

    override suspend fun editProfile(name: String): Profile {
        throw NotImplementedError()
    }

}