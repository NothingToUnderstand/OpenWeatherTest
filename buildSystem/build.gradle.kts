plugins {
    `kotlin-dsl`
}

group = "com.example.openweathertest.buildsystem"

kotlin {
    jvmToolchain(17)
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    google()
}


gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "open.weather.android.application"
            implementationClass = "plugins.AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "open.weather.android.library"
            implementationClass = "plugins.AndroidLibraryConventionPlugin"
        }
        register("kotlinLibrary") {
            id = "open.weather.kotlin.library"
            implementationClass = "plugins.KotlinLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "open.weather.android.feature"
            implementationClass = "plugins.AndroidFeatureConventionPlugin"
        }
    }
}
dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.serializationPlugin)
    //Needed for gradle accessors to work properly
    compileOnly(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
