
plugins {
    id("open.weather.android.application")
}

android {
    namespace = "com.example.openweathertest"
}

dependencies {
    implementation(projects.ui)
}