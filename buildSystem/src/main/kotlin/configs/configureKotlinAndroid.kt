package configs

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import extensions.libs
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

internal fun ApplicationExtension.configureKotlinAndroid(project: Project) = with(project) {

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    configureKotlinAndroidInternal(this)

    buildFeatures {
        compose = true
    }
}

internal fun LibraryExtension.configureKotlinAndroid(project: Project) = with(project) {

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    configureKotlinAndroidInternal(this)

}

private fun CommonExtension<*, *, *, *, *, *>.configureKotlinAndroidInternal(project: Project) =
    with(project) {
        compileSdk {
            version = release(libs.versions.compileSdk.get().toInt())
        }
        configure<KotlinAndroidProjectExtension> {
            jvmToolchain(libs.versions.jvmTarget.get().toInt())
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }

    }