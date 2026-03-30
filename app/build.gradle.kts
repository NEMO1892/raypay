plugins {
    alias(libs.plugins.raypay.android.application)
    alias(libs.plugins.raypay.android.application.compose)
    alias(libs.plugins.raypay.hilt)
}

android {
    namespace = "com.org.raypay"

    defaultConfig {
        applicationId = "com.org.raypay"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(projects.data.auth)

    implementation(projects.domain.auth)

    implementation(projects.features.auth)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}