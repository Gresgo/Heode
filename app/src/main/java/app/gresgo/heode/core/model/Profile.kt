package app.gresgo.heode.core.model

import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("username")
    val name: String,
    val avatar: String = "",
    val email: String
)