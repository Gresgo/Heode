package app.gresgo.heode.core.network

import app.gresgo.heode.core.model.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface HeodeApi {

    companion object {
        const val signUp = "auth/users"
        const val signIn = "auth/token/login"
        const val save = "save"
    }

    // auth

    @POST("$signUp/")
    suspend fun signUp(
        @Body body: SignUpModel
    ): Response<Unit>

    @POST("$signIn/")
    suspend fun signIn(
        @Body body: SignInModel
    ): Response<AuthToken>


    @POST("$save/")
    suspend fun addLocation(
        @Body body: LocationUpdate
    ) : Response<Unit>

}