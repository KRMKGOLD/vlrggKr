package kr.co.cotton.buildsrc

object DependencyInfo {

    object AndroidX {

        const val ktx = "androidx.core:core-ktx:1.9.0"
        const val lifeCycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:alpha03"
        const val appCompat = "androidx.appcompat:appcompat:1.5.1"
        const val junit = "androidx.test.ext:junit:1.1.4"
        const val espresso = "androidx.test.espresso:espresso-core:3.5.0"

        object Compose {
            const val version = "1.3.1"

            const val compose = "androidx.activity:activity-compose:1.6.1"

            const val ui = "androidx.compose.ui:ui:$version"
            const val material = "androidx.compose.material:material:$version"
            const val preview = "androidx.compose.ui:ui-tooling-preview:$version"
            const val test = "androidx.compose.ui:ui-test-junit4:$version"
            const val tool = "androidx.compose.ui:ui-tooling:$version"
            const val manifest = "androidx.compose.ui:ui-test-manifest:$version"

            const val navigation = "androidx.navigation:navigation-compose:2.5.3"
            const val lifecycle = "androidx.lifecycle:lifecycle-runtime-compose:2.6.0-alpha03"
            const val lifecycleViewModel =
                "androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0-alpha03"
        }
    }

    object Test {

        const val junit = "junit:junit:4.13.2"
    }

    object Jsoup {

        const val jsoup = "org.jsoup:jsoup:1.15.3"
    }

    object Hilt {

        const val version = "2.44"

        const val hilt = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
        const val compose = "androidx.hilt:hilt-navigation-compose:1.0.0"
    }

    object Glide {

        const val version = "4.13.2"

        const val glide = "com.github.bumptech.glide:glide:$version"
        const val compiler = "com.github.bumptech.glide:compiler:$version"
    }

    object FlagKit {

        const val version = "1.0.2"

        const val flagKit = "com.github.murgupluoglu:flagkit-android:$version"
    }
}