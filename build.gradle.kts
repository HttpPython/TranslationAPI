plugins {
    kotlin("jvm") version "1.6.20"
}

group = "net.httppython"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
    maven {url=uri("https://jitpack.io")}
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("me.carleslc.Simple-YAML:Simple-Yaml:1.8")
}