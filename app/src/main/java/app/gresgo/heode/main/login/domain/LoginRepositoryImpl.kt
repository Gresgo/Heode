package app.gresgo.heode.main.login.domain

import app.gresgo.heode.base.domain.NetworkRepository
import app.gresgo.heode.core.model.SignInModel
import app.gresgo.heode.core.model.SignUpModel
import app.gresgo.heode.core.network.HeodeApi

class LoginRepositoryImpl(
    private val heodeApi: HeodeApi
): NetworkRepository(), LoginRepository {

    override suspend fun signIn(email: String, password: String): String {
        val response = heodeApi.signIn(SignInModel(email, password)).getResponseBody()
        return response.get()
    }

    override suspend fun signUp(name: String, email: String, password: String): String {
        val response = heodeApi.signUp(SignUpModel(name, email, password))
        if (response.isSuccessful) {
            return signIn(email, password)
        } else {
            throw Exception("Authorization error")
        }
    }

}