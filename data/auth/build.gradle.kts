plugins {
    alias(libs.plugins.raypay.android.library)
    alias(libs.plugins.raypay.hilt)
}

android {
    namespace = "com.org.data.auth"
}

dependencies {
    implementation(projects.core.firebase)

    implementation(projects.domain.auth)
}
