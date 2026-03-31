plugins {
    alias(libs.plugins.raypay.android.library)
}

android {
    namespace = "com.org.core.navigation"
}

dependencies {
    implementation(projects.core.designSystem)
}