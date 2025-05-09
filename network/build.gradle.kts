import dependencies.RemoteDep

plugins {
    id(Config.Plugins.com_android_library)
    id(Config.Plugins.org_jetbrains_kotlin_android)
    alias(libs.plugins.kapt.plagin)
}

android {
    namespace = Config.Android.nameSpaceNetwork
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

    // Kotlin
    implementation(RemoteDep.kotlin)
    // JavaX
    implementation(RemoteDep.javax)
    // Network (Retrofit)
    RemoteDep.retrofit.forEach { implementation(it) }
    implementation(libs.converter.gson)
    // Coroutines
    implementation(RemoteDep.coroutineCore)
    implementation(RemoteDep.coreKtx)

    implementation(libs.logging.interceptor)
}