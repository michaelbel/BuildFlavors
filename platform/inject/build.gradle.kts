plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.google.hilt)
}

kotlin {
    jvmToolchain(libs.versions.jdk.get().toInt())
}

android {
    namespace = "org.michaelbel.platform.inject"
    compileSdk = libs.versions.compile.sdk.get().toInt()

    flavorDimensions += "store"
    productFlavors {
        create("gms") {
            dimension = "store"
            isDefault = true
        }
        create("hms") {
            dimension = "store"
        }
        create("foss") {
            dimension = "store"
        }
    }
}

val gmsImplementation by configurations
val hmsImplementation by configurations
val fossImplementation by configurations
dependencies {
    gmsImplementation(projects.platform.gms)
    hmsImplementation(projects.platform.hms)
    fossImplementation(projects.platform.foss)
    api(projects.platform.interactor)
    implementation(libs.google.hilt.android)
    ksp(libs.google.hilt.compiler)
}