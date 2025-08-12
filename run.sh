#!/bin/bash

# Exit immediately if any command fails
set -e

# Build shadow jar
echo "📦 Building shadow jar..."
./gradlew shadowJar

# Find the built shadow jar (in build/libs)
JAR_FILE="build/libs/movie-mcp-server.jar"

if [[ -z "$JAR_FILE" ]]; then
    echo "❌ No shadow jar found!"
    exit 1
fi

echo "✅ Shadow jar built: $JAR_FILE"

# Run MCP server with supergateway
npx -y supergateway \
  --stdio "java -jar "$JAR_FILE"" \
  --outputTransport streamableHttp \
  --port 9000
