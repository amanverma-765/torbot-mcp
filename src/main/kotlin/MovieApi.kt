import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.toList
import torrentsearch.TorrentSearch
import torrentsearch.models.Category
import util.extractMagnetHash

suspend fun searchForMovie(query: String): List<Map<String, String>> {
    val torrentSearch = TorrentSearch()

    val torrents = torrentSearch.search {
        content = query
        limit = 2
        category = Category.VIDEO
    }.torrents()
        .filter { !it.magnetUrl.isNullOrBlank() }
        .toList()

    return torrents
        .sortedByDescending { it.seeds }
        .take(5)
        .mapNotNull { torrent ->
            val magnetHash = extractMagnetHash(torrent.magnetUrl!!)
            magnetHash?.let { hash ->
                mapOf(
                    "provider" to torrent.provider,
                    "title" to torrent.title,
                    "seeders" to torrent.seeds.toString(),
                    "downloadOrStreamLink" to "https://webtor.io/$hash"
                )
            }
        }
}


