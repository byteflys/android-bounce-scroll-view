plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 34
    defaultConfig {
        namespace = "com.android.library.bouncescrollview"
        minSdk = 30
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    sourceSets {
        getByName("main").java.srcDirs("src/main/commons")
    }
}
dependencies {
    api("androidx.core:core:1.13.1")
}
