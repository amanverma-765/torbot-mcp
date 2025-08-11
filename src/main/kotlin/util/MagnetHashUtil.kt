package util

fun extractMagnetHash(magnetUrl: String): String? {
    val regex = Regex("btih:([A-Fa-f0-9]{40})")
    val match = regex.find(magnetUrl)
    return match?.groupValues?.get(1)?.lowercase()
}