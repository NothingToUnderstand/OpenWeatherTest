package plugins

import com.android.build.api.dsl.LibraryExtension
import extensions.debugImplementation
import extensions.implementation
import extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(project: Project): Unit = with(project) {
        pluginManager.apply("open.weather.android.library")
        pluginManager.apply(libs.plugins.kotlin.compose.get().pluginId)
        extensions.configure<LibraryExtension> {
            buildFeatures {
                compose = true
            }
        }
        dependencies {
            implementation(libs.androidx.lifecycle.runtime.ktx)
            implementation(libs.androidx.activity.compose)
            implementation(libs.androidx.appcompat)
            implementation(libs.material)
            implementation(platform(libs.androidx.compose.bom))
            implementation(libs.androidx.compose.ui)
            implementation(libs.androidx.compose.ui.graphics)
            implementation(libs.androidx.compose.material3)
            debugImplementation(libs.androidx.compose.ui.tooling.preview)
            debugImplementation(libs.androidx.compose.ui.tooling)
            implementation(libs.coil)
            implementation(libs.navigation)
            implementation(libs.lifecycle.runtime)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.nav)
            implementation(libs.koin.android)
        }
    }
}