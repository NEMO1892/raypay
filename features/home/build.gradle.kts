plugins {
    alias(libs.plugins.raypay.android.library)
    alias(libs.plugins.raypay.android.library.compose)
    alias(libs.plugins.raypay.hilt)
}

android {
    namespace = "com.org.features.home"
}

dependencies {
    implementation(projects.core.navigation)
    implementation(projects.core.designSystem)
}
