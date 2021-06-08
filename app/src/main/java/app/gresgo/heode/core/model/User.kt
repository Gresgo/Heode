package app.gresgo.heode.core.model

data class User(
    val id: Int,
    val name: String,
    val avatar: String = "",
    val location: UserLocation?
)