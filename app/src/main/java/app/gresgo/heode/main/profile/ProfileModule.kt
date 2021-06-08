package app.gresgo.heode.main.profile

import app.gresgo.heode.main.profile.domain.ProfileRepository
import app.gresgo.heode.main.profile.domain.ProfileRepositoryImpl
import app.gresgo.heode.main.profile.ui.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ProfileModule {

    fun create() = module {
        single<ProfileRepository> { ProfileRepositoryImpl(get()) }
        viewModel { ProfileViewModel(get()) }
    }

}