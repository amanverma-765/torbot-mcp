package util

import kotlinx.serialization.Serializable

@Serializable
data class About(
    val name: String,
    val description: String
)
