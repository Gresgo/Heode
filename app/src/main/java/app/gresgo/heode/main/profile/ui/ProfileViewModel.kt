package app.gresgo.heode.main.profile.ui

import androidx.databinding.ObservableField
import app.gresgo.heode.base.ui.BaseViewModel
import app.gresgo.heode.core.model.Profile
import app.gresgo.heode.main.profile.data.ProfileRepository

class ProfileViewModel(
    private val profileRepository: ProfileRepository
): BaseViewModel() {

    val profile = ObservableField<Profile>()

    init {
        loadProfile()
    }

    fun loadProfile() {
        launchLoadingJob {
            profile.set(profileRepository.getProfile())
        }
    }

    fun editProfile(name: String) {
        launchJob {
            profile.set(profileRepository.editProfile(name))
        }
    }

}