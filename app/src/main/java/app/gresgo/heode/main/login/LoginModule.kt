package app.gresgo.heode.main.login

import app.gresgo.heode.main.login.data.LoginRepository
import app.gresgo.heode.main.login.data.LoginRepositoryImpl
import app.gresgo.heode.main.login.ui.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object LoginModule {

    fun create() = module {
        single<LoginRepository> { LoginRepositoryImpl(get()) }
        viewModel { LoginViewModel(get()) }
    }

}