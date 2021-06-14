package app.gresgo.heode.main.login.data

interface LoginRepository {

    suspend fun signUp(name: String, email: String, password: String): String

    suspend fun signIn(email: String, password: String): String

}