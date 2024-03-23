plugins {
    idea
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
    id("com.google.devtools.ksp")
}

apply(plugin = "io.spring.dependency-management")

val komapperVersion: String by project
dependencies {
    platform("org.komapper:komapper-platform:$komapperVersion").let {
        implementation(it)
        ksp(it)
    }
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.komapper:komapper-spring-boot-starter-r2dbc")
    implementation("org.komapper:komapper-dialect-mysql-r2dbc")
    ksp("org.komapper:komapper-processor")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

springBoot {
    mainClass.set("org.komapper.example.ApplicationKt")
}

repositories {
    mavenLocal()
    mavenCentral()
}

tasks {
    withType<Test>().configureEach {
        useJUnitPlatform()
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = "17"
    }
}