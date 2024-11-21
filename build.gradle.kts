plugins {
    kotlin("jvm") version "2.1.0-RC2"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "io.github.iamforyydev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    //maven("https://repo.papermc.io/repository/maven-public/") {
    //    name = "papermc-repo"
    //}
    //maven("https://oss.sonatype.org/content/groups/public/") {
    //    name = "sonatype"
    //}
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
    //implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

val targetJavaVersion = 21
kotlin {
    jvmToolchain(targetJavaVersion)
}


tasks {

    shadowJar {

        archiveBaseName.set(rootProject.name)
        archiveVersion.set("$rootProject.version")
        archiveClassifier.set("dev")

    }

    build {
        dependsOn("shadowJar")
    }
}

tasks.processResources {
    val props = mapOf("version" to version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("paper-plugin.yml") {
        expand(props)
    }
}