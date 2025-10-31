plugins {
    id("open.weather.android.library")
}

android {
    namespace = "com.example.data"
}

dependencies {
    implementation(projects.domain)
}