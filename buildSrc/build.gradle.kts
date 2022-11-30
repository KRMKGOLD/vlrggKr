plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

object PluginVersion {

    const val gradle = "7.0.3"
    const val kotlin = "1.7.10"
}

dependencies {

    implementation("com.android.tools.build:gradle:${PluginVersion.gradle}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginVersion.kotlin}")
}

