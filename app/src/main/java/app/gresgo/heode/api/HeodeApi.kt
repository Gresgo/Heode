package app.gresgo.heode.api

import app.gresgo.heode.model.UserLocation
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface HeodeApi {

    companion object {
        const val save = "save"
    }

    @POST("$save/")
    fun addLocation(
        @Body body: UserLocation
    ) : Single<Response<Unit>>

}