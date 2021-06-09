package app.gresgo.heode.main.profile.domain

import app.gresgo.heode.core.model.Profile

interface ProfileRepository {

    suspend fun getProfile(): Profile

    suspend fun editProfile(name: String): Profile

}