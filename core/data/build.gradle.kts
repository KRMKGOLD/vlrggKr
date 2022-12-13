import kr.co.cotton.buildsrc.DependencyInfo

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    compileSdk = 33

    defaultConfig {
        minSdk = 23
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    testImplementation(DependencyInfo.Test.junit)
    androidTestImplementation(DependencyInfo.AndroidX.junit)

    implementation(DependencyInfo.Jsoup.jsoup)

    implementation(DependencyInfo.Hilt.hilt)
    implementation(DependencyInfo.Hilt.compose)
    kapt(DependencyInfo.Hilt.compiler)

    implementation(DependencyInfo.AndroidX.Paging3.runtime)
}