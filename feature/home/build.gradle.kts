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
        vectorDrawables.useSupportLibrary = true
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

    implementation(project(":core:designsystem"))
    implementation(project(":feature:news"))

    implementation(DependencyInfo.AndroidX.ktx)
    implementation(DependencyInfo.AndroidX.appCompat)
    implementation(DependencyInfo.AndroidX.lifeCycleRuntime)

    implementation(DependencyInfo.AndroidX.Compose.ui)
    implementation(DependencyInfo.AndroidX.Compose.material)
    implementation(DependencyInfo.AndroidX.Compose.preview)
    implementation(DependencyInfo.AndroidX.Compose.compose)
    debugImplementation(DependencyInfo.AndroidX.Compose.tool)
    debugImplementation(DependencyInfo.AndroidX.Compose.manifest)
    debugImplementation(DependencyInfo.AndroidX.Compose.lifecycle)
    debugImplementation(DependencyInfo.AndroidX.Compose.lifecycleViewModel)

    testImplementation(DependencyInfo.Test.junit)
    androidTestImplementation(DependencyInfo.AndroidX.junit)
    androidTestImplementation(DependencyInfo.AndroidX.espresso)
    androidTestImplementation(DependencyInfo.AndroidX.Compose.test)

    implementation(DependencyInfo.Hilt.hilt)
    implementation(DependencyInfo.Hilt.compose)
    kapt(DependencyInfo.Hilt.compiler)

    implementation(DependencyInfo.Glide.glide)
    kapt(DependencyInfo.Glide.compiler)
}