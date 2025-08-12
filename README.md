<div align="center">

# ✨ **TorBot MCP** ✨

<img src="https://img.shields.io/badge/Status-Active-green" alt="Status"/>
<img src="https://img.shields.io/badge/Language-Kotlin-blue" alt="Kotlin"/>
<img src="https://img.shields.io/badge/Protocol-MCP-yellow" alt="MCP Protocol"/>

<br/>

🚀 **MCP server to download movies & anime directly from torrent sites!**
🎬 Provides instant streamable & downloadable links via MCP protocol.

</div>

---

## Overview

**torbot-mcp** is a Kotlin-based MCP server built to integrate with the Puch.ai ecosystem, enabling direct downloading and streaming of movies and anime from torrent sites. Using MCP, it delivers instant streamable and downloadable links, empowering WhatsApp bots and other clients to serve content seamlessly.

---

## Features

* 🔗 Fully integrated MCP protocol server
* 🎥 Direct torrent downloading for movies & anime
* 📺 Provides both streamable and downloadable links
* ⚡ Fast, efficient Kotlin implementation
* 🛠️ Easy to start with a single command

---

## Getting Started

To build and run the server, simply execute the included run script:

```bash
 ./run.bash
```

This will start the MCP server and expose streamable HTTP endpoints for media delivery.

---

## Command Reference

| Command                             | Description                                                                                                                                               | Example                                                |          |                                                  |                                |
| ----------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------ | -------- | ------------------------------------------------ | ------------------------------ |
| `/mcp connect <url> <bearer_token>` | Connect your MCP server with Puch AI using a bearer token. Your server must validate the token and return the user's phone number (e.g., `919876543210`). | `/mcp connect https://mcp.example.com/mcp abc123token` |          |                                                  |                                |
| `/mcp connect <url>`                | Connect using OAuth authentication. A browser window may open for user consent.                                                                           | `/mcp connect https://mcp.example.com/mcp`             |          |                                                  |                                |
| `/mcp use <server_id>`              | Connect to a hosted MCP server by its unique ID. You can connect up to 5 servers at once.                                                                 | `/mcp use abc123`                                      |          |                                                  |                                |
| `/mcp remove <server_id>`           | Remove a hosted MCP server from your list.                                                                                                                | `/mcp remove abc123`                                   |          |                                                  |                                |
| `/mcp list`                         | List all your connected MCP servers and configurations.                                                                                                   | `/mcp list`                                            |          |                                                  |                                |
| `/mcp deactivate`                   | Disconnect safely from all active MCP servers, revoking access to their tools.                                                                            | `/mcp deactivate`                                      |          |                                                  |                                |
| \`/mcp diagnostics-level (error     | warn                                                                                                                                                      | info                                                   | debug)\` | Set the diagnostic log level for MCP operations. | `/mcp diagnostics-level debug` |
| `/mcp disable <server_id>`          | Disable a specific MCP server (tools become unavailable, but connection remains). Useful for debugging.                                                   | `/mcp disable abc123`                                  |          |                                                  |                                |
| `/mcp enable <server_id>`           | Enable a previously disabled MCP server.                                                                                                                  | `/mcp enable abc123`                                   |          |                                                  |                                |

> **Note:** The validate tool on your MCP server **must** accept the bearer token and return the user's phone number (including country code) for authentication to succeed.

---

## Usage

Connect your Puch AI WhatsApp bot or any MCP client to this server to fetch torrent-based media instantly and reliably.

---

## Contribution

Contributions, bug reports, and feature requests are welcome! Feel free to open issues or pull requests.

---

## Acknowledgments

Thanks to the Puch.ai hackathon for the inspiration and opportunity to build this project!
