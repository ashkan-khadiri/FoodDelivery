import dependencies.PresentationDep
import dependencies.UiDep

plugins {
    id(Config.Plugins.com_android_library)
    id(Config.Plugins.org_jetbrains_kotlin_android)
    alias(libs.plugins.kapt.plagin)
    alias(libs.plugins.dagger.hilt.plugins)
    alias(libs.plugins.ksp)
}

android {
    namespace = Config.Android.nameSpacePresentation
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
}

dependencies {

    implementation(project(Modules.core))

    // LifeCycle
    PresentationDep.lifeCycle.forEach {
        implementation(it)
    }

    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

}