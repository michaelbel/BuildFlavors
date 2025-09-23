import java.nio.charset.StandardCharsets

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.google.hilt)
}

if (isGmsBuild) {
    plugins {
        alias(libs.plugins.google.services)
    }
}
if (isHmsBuild) {
    plugins {
        alias(libs.plugins.huawei.services)
    }
}

private val gitCommitsCount: Int by lazy {
    try {
        val isWindows = System.getProperty("os.name").contains("Windows", ignoreCase = true)
        val processBuilder = when {
            isWindows -> ProcessBuilder("cmd", "/c", "git", "rev-list", "--count", "HEAD")
            else -> ProcessBuilder("git", "rev-list", "--count", "HEAD")
        }
        processBuilder.redirectErrorStream(true)
        processBuilder.start().inputStream.bufferedReader(StandardCharsets.UTF_8).readLine().trim().toInt()
    } catch (_: Exception) {
        1
    }
}

kotlin {
    jvmToolchain(libs.versions.jdk.get().toInt())
}

android {
    namespace = "org.michaelbel.buildflavors"
    compileSdk = libs.versions.compile.sdk.get().toInt()

    defaultConfig {
        applicationId = "org.michaelbel.buildflavors"
        minSdk = libs.versions.min.sdk.get().toInt()
        targetSdk = libs.versions.target.sdk.get().toInt()
        versionCode = gitCommitsCount
        versionName = "1.0.0"
    }

    signingConfigs {
        getByName("debug") {
            keyAlias = "buildflavors"
            keyPassword = "password"
            storeFile = rootProject.file(".github/debug-key.jks")
            storePassword = "password"
        }
    }

    buildTypes {
        debug {
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    buildFeatures {
        compose = true
    }

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

base {
    archivesName.set("BuildFlavors-v${android.defaultConfig.versionName}(${android.defaultConfig.versionCode})")
}

val gmsImplementation by configurations
val hmsImplementation by configurations
val fossImplementation by configurations
dependencies {
    gmsImplementation(projects.platformServices.inject)
    hmsImplementation(projects.platformServices.inject)
    fossImplementation(projects.platformServices.inject)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.google.hilt.android)
    ksp(libs.google.hilt.compiler)
    implementation(libs.google.material)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
}

tasks.register("printVersion") {
    doLast {
        println("VERSION_NAME=${android.defaultConfig.versionName}")
        println("VERSION_CODE=${android.defaultConfig.versionCode}")
    }
}