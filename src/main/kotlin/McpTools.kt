import io.modelcontextprotocol.kotlin.sdk.CallToolResult
import io.modelcontextprotocol.kotlin.sdk.TextContent
import io.modelcontextprotocol.kotlin.sdk.Tool
import io.modelcontextprotocol.kotlin.sdk.server.Server
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.put
import kotlinx.serialization.json.putJsonObject
import util.About

fun registerTools(server: Server) {
    server.addTool(
        name = "search_for_movies",
        description = """
        🎬 Search movies & anime by name or keywords.
        📥 Download instantly in high quality.
        📺 Stream live without waiting.
    """.trimIndent(),
        inputSchema = Tool.Input(
            properties = buildJsonObject {
                putJsonObject("query") {
                    put("type", "string")
                    put("description", "The movie or anime name or keywords to search for.")
                }
            },
            required = listOf("query")
        )
    ) { request -> // This lambda can be suspend in MCP
        val query = request.arguments["query"]?.jsonPrimitive?.content ?: return@addTool CallToolResult(
            content = listOf(TextContent("The query parameter is required."))
        )

        val movies = searchForMovie(query)

        if (movies.isEmpty()) {
            return@addTool CallToolResult(
                content = listOf(TextContent("❌ No results found for \"$query\"."))
            )
        }

        val output = buildString {
            appendLine("🎬 Search Results for \"$query\"")
            appendLine("------------------------------")
            movies.forEachIndexed { index, movie ->
                appendLine("${index + 1}. ${movie["title"]}")
                appendLine("   Provider: ${movie["provider"]}")
                appendLine("   downloadOrStreamLink: ${movie["downloadOrStreamLink"]}")
                appendLine()
            }
        }
        CallToolResult(content = listOf(TextContent(output)))
    }

    server.addTool(
        name = "validate",
        description = "validates the server configuration and tools",
    ) {
        CallToolResult(content = listOf(TextContent("916386617608")))
    }

    server.addTool(
        name = "about",
        description = "gets the general information about the server",
    ) {
        val about = About(
            name = "Movie Downloader & Live Streamer",
            description = "A server for searching, streaming and downloading movies and anime."
        )
        CallToolResult(content = listOf(TextContent(Json.encodeToString(about))))
    }
}