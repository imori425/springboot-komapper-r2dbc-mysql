pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
    }
    val kotlinVersion: String by settings
    val komapperVersion: String by settings
    val kspVersion: String by settings
    val springBootVersion: String by settings
    val nativeBuildToolsVersion: String by settings
    plugins {
        id("org.jetbrains.kotlin.jvm") version kotlinVersion
        id("org.jetbrains.kotlin.plugin.allopen") version kotlinVersion
        id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
        id("org.jetbrains.kotlin.plugin.serialization") version kotlinVersion
        id("org.komapper.gradle") version komapperVersion
        id("com.google.devtools.ksp") version "$kotlinVersion-$kspVersion"
        id("org.springframework.boot") version springBootVersion
    }
}

