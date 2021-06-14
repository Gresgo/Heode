package app.gresgo.heode.main.login.data

import app.gresgo.heode.base.domain.NetworkRepository
import app.gresgo.heode.core.model.SignInModel
import app.gresgo.heode.core.model.SignUpModel
import app.gresgo.heode.core.network.HeodeApi
import timber.log.Timber

class LoginRepositoryImpl(
    private val heodeApi: HeodeApi
): NetworkRepository(), LoginRepository {

    override suspend fun signIn(email: String, password: String): String {
        Timber.i("Launch signIn")
        val response = heodeApi.signIn(SignInModel(email, password)).getResponseBody()
        return response.get().also { Timber.i("Get token $it") }
    }

    override suspend fun signUp(name: String, email: String, password: String): String {
        Timber.i("Launch signUp")
        val response = heodeApi.signUp(SignUpModel(name, email, password))
        if (response.isSuccessful) {
            Timber.i("Account created")
            return signIn(email, password)
        } else {
            throw Exception("Authorization error")
        }
    }

}