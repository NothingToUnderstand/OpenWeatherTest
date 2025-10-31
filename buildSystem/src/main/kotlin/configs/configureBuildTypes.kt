package configs

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import extensions.getPropertyOrEnv
import java.util.Properties

fun BaseAppModuleExtension.configureBuildTypes(
    properties: Properties,
) = buildTypes {

    debug {
        applicationIdSuffix = ".dev"
        buildConfigField(
            "String",
            "OPEN_WEATHER_API_KEY",
            "\"${properties.getPropertyOrEnv("OPEN_WEATHER_API_KEY")}\""
        )
    }

    release {
        isMinifyEnabled = true
        isShrinkResources = true
        isDebuggable = false

        proguardFiles(
            getDefaultProguardFile("proguard-android-optimize.txt"),
            "proguard-rules.pro",
        )

        buildConfigField(
            "String",
            "OPEN_WEATHER_API_KEY",
            "\"${properties.getPropertyOrEnv("OPEN_WEATHER_API_KEY")}\""
        )
    }


    buildFeatures {
        buildConfig = true
    }
}
