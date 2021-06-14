package app.gresgo.heode.main.login.ui

import app.gresgo.heode.base.ui.BaseViewModel
import app.gresgo.heode.main.login.data.LoginRepository
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel(
    private val loginRepository: LoginRepository
): BaseViewModel() {

    val token = MutableStateFlow<String?>(null)

    fun signUp(name: String, email: String, password: String) {
        launchLoadingJob {
            token.value = loginRepository.signUp(name, email, password)
        }
    }

    fun signIn(email: String, password: String) {
        launchLoadingJob {
            token.value = loginRepository.signIn(email, password)
        }
    }

}