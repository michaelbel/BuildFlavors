plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

kotlin {
    jvmToolchain(libs.versions.jdk.get().toInt())
}

android {
    namespace = "org.michaelbel.platform.interactor"
    compileSdk = libs.versions.compile.sdk.get().toInt()
}

dependencies {
    api(libs.kotlinx.coroutines.android)
    api(libs.google.hilt.android)
}