plugins {
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
    id("org.jlleitschuh.gradle.ktlint-idea") version "11.0.0"
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.jlleitschuh.gradle:ktlint-gradle:11.0.0")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
