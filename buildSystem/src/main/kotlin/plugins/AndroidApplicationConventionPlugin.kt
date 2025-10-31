package plugins

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import configs.configureBuildTypes
import configs.configureKotlinAndroid
import extensions.implementation
import extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.provideDelegate
import java.util.Properties
import org.gradle.kotlin.dsl.dependencies

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(project: Project): Unit = with(project) {
        val localProperties by lazy {
            Properties().apply {
                val localProperties = project.rootProject.file("local.properties")
                if (localProperties.exists()) {
                    load(localProperties.reader())
                }
            }
        }

        pluginManager.apply(libs.plugins.android.application.get().pluginId)
        pluginManager.apply(libs.plugins.kotlin.android.get().pluginId)
        pluginManager.apply(libs.plugins.kotlin.compose.get().pluginId)

        extensions.configure<ApplicationExtension> {
            configureKotlinAndroid(project)
        }
        extensions.configure<BaseAppModuleExtension> {
            configureBuildTypes(localProperties)
        }

        dependencies {
            implementation(libs.androidx.core.ktx)
            implementation(libs.androidx.lifecycle.runtime.ktx)
            implementation(libs.androidx.activity.compose)
        }
    }
}