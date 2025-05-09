object Config {

    const val jvmTarget: String = "1.8" //"1.8"
    object Android {
        const val nameSpace = "com.arshtestproject"
        const val nameSpaceApp = "$nameSpace"
        const val nameSpaceCore = "$nameSpace.core"
        const val nameSpaceData = "$nameSpace.data"
        const val nameSpacePresentation = "$nameSpace.presentation"
        const val nameSpaceNetwork = "$nameSpace.network"
    }

    object ClassPaths {
        const val androidGradle = "com.android.tools.build:gradle:${Versions.gradleVersion}"
        const val kotlinGradle =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
        const val navigationSafArgsGradle =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.gradleNavigationArgVersion}"
        const val ktLint = "org.jlleitschuh.gradle:ktlint-gradle:${Versions.ktLintVersion}"

        const val jitPackUrl = "https://jitpack.io"
        const val googleUrl = "https://maven.google.com/"
        const val pluginGradle = "https://plugins.gradle.org/m2/"
        const val pluginKtLint = "org.jlleitschuh.gradle.ktlint"

        const val googleService =
            "com.google.gms:google-services:${Versions.googleClassPassGmsVersion}"
    }

    object Plugins {
        const val com_android_application = "com.android.application"
        const val com_android_library = "com.android.library"
        const val org_jetbrains_kotlin_android = "org.jetbrains.kotlin.android"
        const val kotlin = "kotlin"
        const val javaLibrary = "java-library"
        const val kotlinAndroid = "kotlin-android"
        const val navigationSafArgs = "androidx.navigation.safeargs.kotlin"
        const val dagger = "dagger.hilt.android.plugin"
        const val parcelize = "kotlin-parcelize"
        const val gsmServicePlugin = "com.google.gms.google-services"
    }
}