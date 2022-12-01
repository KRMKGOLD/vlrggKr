import kr.co.cotton.buildsrc.DependencyInfo

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android") version "2.44"
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "kr.co.cotton.vlrggaos"
        minSdk = 23
        targetSdk = 32
        vectorDrawables.useSupportLibrary = true
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = DependencyInfo.AndroidX.Compose.version
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(DependencyInfo.AndroidX.ktx)
    implementation(DependencyInfo.AndroidX.Compose.ui)
    implementation(DependencyInfo.AndroidX.Compose.material)
    implementation(DependencyInfo.AndroidX.Compose.preview)
    implementation(DependencyInfo.AndroidX.appCompat)
    implementation(DependencyInfo.AndroidX.lifeCycleRuntime)
    implementation(DependencyInfo.AndroidX.Compose.compose)
    testImplementation(DependencyInfo.Test.junit)
    androidTestImplementation(DependencyInfo.AndroidX.junit)
    androidTestImplementation(DependencyInfo.AndroidX.espresso)
    androidTestImplementation(DependencyInfo.AndroidX.Compose.test)
    debugImplementation(DependencyInfo.AndroidX.Compose.tool)
    debugImplementation(DependencyInfo.AndroidX.Compose.manifest)

    implementation(DependencyInfo.Jsoup.jsoup)

    implementation(DependencyInfo.Hilt.hilt)
    kapt(DependencyInfo.Hilt.compiler)

    implementation(DependencyInfo.Glide.glide)
    kapt(DependencyInfo.Glide.compiler)
}