package plugins

import com.android.build.api.dsl.LibraryExtension
import configs.configureKotlinAndroid
import extensions.implementation
import extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies


class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) = with(project) {
        pluginManager.apply(libs.plugins.android.library.get().pluginId)
        pluginManager.apply(libs.plugins.kotlin.android.get().pluginId)
        pluginManager.apply(libs.plugins.kotlinx.serialization.get().pluginId)

        extensions.configure<LibraryExtension> {
            configureKotlinAndroid(project)
        }

        dependencies {
            implementation(libs.androidx.core.ktx)
            implementation(libs.bundles.retrofit)
            implementation(libs.koin.core)
        }
    }
}