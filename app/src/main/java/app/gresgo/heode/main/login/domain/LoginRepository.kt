package app.gresgo.heode.main.login.domain

interface LoginRepository {

    suspend fun signUp(name: String, email: String, password: String): String

    suspend fun signIn(email: String, password: String): String

}