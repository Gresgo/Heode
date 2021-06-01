package app.gresgo.heode.model

import com.google.gson.annotations.SerializedName

data class UserLocation(
    val user: String,
    val dots: LocationUpdate
)

data class LocationUpdate(
    val longitude: Double,
    val latitude: Double,
    val speed: Float,
    @SerializedName("accurancy")
    val accuracy: Float,
    val timestamp: Long
)