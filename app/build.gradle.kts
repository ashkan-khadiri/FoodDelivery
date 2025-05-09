import dependencies.UiDep

plugins {
    id(Config.Plugins.com_android_application)
    id(Config.Plugins.org_jetbrains_kotlin_android)
    alias(libs.plugins.kapt.plagin)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.dagger.hilt.plugins)
    alias(libs.plugins.ksp)
}

android {
    namespace = Config.Android.nameSpaceApp
    compileSdk = 35

    defaultConfig {
        applicationId = "com.arshtestproject"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Modules
    implementation(project(Modules.core))
    implementation(project(Modules.network))
    implementation(project(Modules.data))
    implementation(project(Modules.presentation))

    // Core Dependencies
    implementation(UiDep.kotlin)
    implementation(UiDep.coreKtx)
    implementation(UiDep.appCompat)
    implementation(UiDep.material)
    implementation(UiDep.navigationUiKtx)
    implementation(UiDep.activityKtx)
    implementation(UiDep.viewpager2)

    // LifeCycle
    UiDep.LifeCycle.forEach {
        implementation(it)
    }

    // Glide
    implementation(UiDep.glide)

    UiDep.Coroutines.forEach {
        implementation(it)
    }

    //Retrofit
    implementation(UiDep.retrofit)
    implementation(libs.converter.gson)
    implementation(UiDep.gson)
    implementation(libs.logging.interceptor)

    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.constraintlayout.compose)

    implementation(libs.navigation.compose)

    implementation(libs.timber)

    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    ksp(libs.hilt.android.compiler)
}