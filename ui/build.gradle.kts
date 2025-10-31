plugins {
    id("open.weather.android.feature")
}

android {
    namespace = "com.example.ui"
}

dependencies {
    implementation(projects.domain)
}