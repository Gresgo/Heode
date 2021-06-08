package app.gresgo.heode.core.model

data class UserLocation(
    val latitude: Double,
    val longitude: Double
)

data class LocationUpdate(
    val longitude: Double,
    val latitude: Double,
    val speed: Float,
    val accuracy: Float,
    val timestamp: Long
)