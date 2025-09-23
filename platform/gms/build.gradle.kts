plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

kotlin {
    jvmToolchain(libs.versions.jdk.get().toInt())
}

android {
    namespace = "org.michaelbel.platform.gms"
    compileSdk = libs.versions.compile.sdk.get().toInt()
}

dependencies {
    implementation(projects.platform.common)
    implementation(libs.google.firebase.analytics.ktx)
}