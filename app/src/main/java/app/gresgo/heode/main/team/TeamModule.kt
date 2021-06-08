package app.gresgo.heode.main.team

import app.gresgo.heode.main.team.domain.TeamRepository
import app.gresgo.heode.main.team.domain.TeamRepositoryImpl
import app.gresgo.heode.main.team.ui.TeamViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object TeamModule {

    fun create() = module {
        single<TeamRepository> { TeamRepositoryImpl(get()) }
        viewModel { TeamViewModel(get()) }
    }

}