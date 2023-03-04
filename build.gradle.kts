val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project
val exposedVersion: String by project
val postgresVersion: String by project
val bcryptVersion: String by project
val kredsVersion: String by project
val hikaricpVersion: String by project

plugins {
  application
  kotlin("jvm") version "1.8.10"
  id("io.ktor.plugin") version "2.2.3"
  id("org.jetbrains.kotlin.plugin.serialization") version "1.8.10"
}

group = "com.demco"
version = "0.0.1"
application {
  mainClass.set("com.demco.ApplicationKt")

  val isDevelopment: Boolean = project.ext.has("development")
  applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("io.ktor:ktor-server-core-jvm:$ktorVersion")
  implementation("io.ktor:ktor-server-host-common-jvm:$ktorVersion")
  implementation("io.ktor:ktor-server-status-pages-jvm:$ktorVersion")
  implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktorVersion")
  implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktorVersion")
  implementation("io.ktor:ktor-server-sessions-jvm:$ktorVersion")
  implementation("io.ktor:ktor-server-auth-jvm:$ktorVersion")
  implementation("io.ktor:ktor-server-netty-jvm:$ktorVersion")
  implementation("ch.qos.logback:logback-classic:$logbackVersion")
  implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
  implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
  implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
  implementation("org.postgresql:postgresql:$postgresVersion")
  implementation("at.favre.lib", "bcrypt", bcryptVersion)
  implementation("com.zaxxer", "HikariCP", hikaricpVersion)
  implementation("io.github.crackthecodeabhi", "kreds", kredsVersion)
  testImplementation("io.ktor:ktor-server-tests-jvm:$ktorVersion")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
}

ktor {
  fatJar {
    archiveFileName.set("fat.jar")
  }

  docker {
    jreVersion.set(io.ktor.plugin.features.JreVersion.JRE_17)
    localImageName.set("demco-ff-api")
  }
}
