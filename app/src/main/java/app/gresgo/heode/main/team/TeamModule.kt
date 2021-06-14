package app.gresgo.heode.main.team

import app.gresgo.heode.main.team.data.TeamRepository
import app.gresgo.heode.main.team.data.TeamRepositoryTestImpl
import app.gresgo.heode.main.team.ui.TeamViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object TeamModule {

    fun create() = module {
//        single<TeamRepository> { TeamRepositoryImpl(get()) }
        single<TeamRepository> { TeamRepositoryTestImpl() }
        viewModel { TeamViewModel(get()) }
    }

}