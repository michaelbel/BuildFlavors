plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

kotlin {
    jvmToolchain(libs.versions.jdk.get().toInt())
}

android {
    namespace = "org.michaelbel.platform.hms"
    compileSdk = libs.versions.compile.sdk.get().toInt()
}

dependencies {
    implementation(projects.platformServices.interactor)
    implementation(libs.huawei.hianalytics)
}