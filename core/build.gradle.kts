import dependencies.CoreDep

plugins {
    id(Config.Plugins.com_android_library)
    id(Config.Plugins.org_jetbrains_kotlin_android)
    id(Config.Plugins.parcelize)
}

android {
    namespace = Config.Android.nameSpaceCore
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

    implementation(CoreDep.kotlin)
    implementation(CoreDep.coroutineCore)
    implementation(CoreDep.coreKtx)

    implementation(CoreDep.javax)

}