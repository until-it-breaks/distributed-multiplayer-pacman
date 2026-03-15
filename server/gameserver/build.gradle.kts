plugins {
    id("java")
    id("com.gradleup.shadow") version "9.3.2"
}

group = "it.unibo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    // Source: https://mvnrepository.com/artifact/org.json/json
    implementation("org.json:json:20251224")
}

tasks.test {
    useJUnitPlatform()
}