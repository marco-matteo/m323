plugins {
    kotlin("jvm") version "2.3.21"
    application
}

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

application {
    mainClass.set("MainKt")
}

kotlin {
    jvmToolchain(21)
}