plugins {
    alias(libs.plugins.raypay.android.library)
    alias(libs.plugins.raypay.hilt)
}

android {
    namespace = "com.org.core.common"
}

dependencies {
    implementation(projects.core.designSystem)
}
