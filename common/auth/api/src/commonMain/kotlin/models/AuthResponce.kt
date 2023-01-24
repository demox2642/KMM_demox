package models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthResponce<T>(
    @SerialName("success")
    val success: Boolean,
    @SerialName("response")
    val response: T
)
