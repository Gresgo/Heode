package app.gresgo.heode.core.network

import app.gresgo.heode.core.model.UserLocation
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface HeodeApi {

    companion object {
        const val save = "save"
    }

    @POST("$save/")
    suspend fun addLocation(
        @Body body: UserLocation
    ) : Response<Unit>

}