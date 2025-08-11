plugins {
    kotlin("jvm") version "2.2.0"
    kotlin("plugin.serialization") version "2.2.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("application")
}

group = "com.ark"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("MainKt")
}

tasks.shadowJar {
    archiveFileName.set("movie-mcp-server.jar")
    mergeServiceFiles()
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.drewcarlson:torrentsearch-jvm:0.9.0")
    // --- Ktor HTTP Client ---
    implementation("io.ktor:ktor-client-core:3.2.3")
    implementation("io.ktor:ktor-client-okhttp:3.2.3")
    implementation("io.ktor:ktor-client-logging:3.2.3")
    // Kotlinx Serialization + JSON
    implementation("io.ktor:ktor-serialization-kotlinx-json:3.2.3")
    implementation("io.ktor:ktor-client-content-negotiation:3.2.3")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
    // MCP
    implementation("io.modelcontextprotocol:kotlin-sdk:0.6.0")
    // Ktor server core + Netty engine
    implementation("io.ktor:ktor-server-core:3.2.3")
    implementation("io.ktor:ktor-server-netty:3.2.3")
    // Ktor SSE support
    implementation("io.ktor:ktor-server-sse:3.2.3")
    // Ktor JSON serialization
    implementation("io.ktor:ktor-server-content-negotiation:3.2.3")
    implementation("io.ktor:ktor-serialization-kotlinx-json:3.2.3")
    // Logging
    implementation("ch.qos.logback:logback-classic:1.5.13")
}


tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}