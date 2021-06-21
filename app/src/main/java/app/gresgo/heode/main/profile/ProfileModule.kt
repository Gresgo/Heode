package app.gresgo.heode.main.profile

import app.gresgo.heode.main.profile.data.ProfileRepository
import app.gresgo.heode.main.profile.data.ProfileRepositoryImpl
import app.gresgo.heode.main.profile.data.ProfileRepositoryTestImpl
import app.gresgo.heode.main.profile.ui.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ProfileModule {

    fun create() = module {
        single<ProfileRepository> { ProfileRepositoryImpl(get()) }
//        single<ProfileRepository> { ProfileRepositoryTestImpl() }
        viewModel { ProfileViewModel(get()) }
    }

}