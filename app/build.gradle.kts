plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 34
    defaultConfig {
        namespace = "com.android.code"
        applicationId = "com.android.code.app"
        testApplicationId = "com.android.code.test"
        minSdk = 30
        targetSdk = 34
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
        compose = false
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {

    api(project(":android-bounce-scroll-view"))

    // AndroidX
    api("androidx.appcompat:appcompat:1.7.0")
    api("androidx.activity:activity:1.9.0")
    api("androidx.fragment:fragment:1.7.0")
    api("androidx.constraintlayout:constraintlayout-core:1.0.4")
    api("com.google.android.material:material:1.12.0")

    // Kotlin
    api("androidx.core:core-ktx:1.13.1")

    // Coroutine
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:+")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:+")

    // Lifecycle
    api("androidx.lifecycle:lifecycle-runtime-ktx:+")
    api("androidx.lifecycle:lifecycle-viewmodel-ktx:+")

    // GSON
    api("com.google.code.gson:gson:+")

    // OkHttp3
    api("com.squareup.okhttp3:okhttp:+")
    api("com.squareup.okhttp3:logging-interceptor:+")

    // RxJava3
    api("io.reactivex.rxjava3:rxjava:+")
    api("io.reactivex.rxjava3:rxandroid:+")
    api("com.github.akarnokd:rxjava3-retrofit-adapter:+")

    // Retrofit2
    api("com.squareup.retrofit2:retrofit:+")
    api("com.squareup.retrofit2:converter-gson:+")
    api("com.squareup.retrofit2:adapter-rxjava2:+")

    // MMKV
    api("com.tencent:mmkv-static:+")
}
