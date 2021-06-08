package app.gresgo.heode.core.model

import com.google.gson.annotations.SerializedName

data class SignUpModel(
    val username: String,
    val email: String,
    val password: String
)

data class SignInModel(
    val email: String,
    val password: String
)

data class AuthToken(
    @SerializedName("auth_token")
    private val authToken: String
) {
    fun get() = authToken
}