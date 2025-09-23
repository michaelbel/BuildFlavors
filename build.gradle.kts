plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.google.ksp) apply false
    alias(libs.plugins.google.hilt) apply false
}

if (isGmsBuild) {
    plugins {
        alias(libs.plugins.google.services) apply false
    }
}
if (isHmsBuild) {
    plugins {
        alias(libs.plugins.huawei.services) apply false
    }
}