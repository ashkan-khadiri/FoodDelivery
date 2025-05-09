package dependencies

import Versions
//import dependencies.Dependencies.kapt
import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {

    object Google {
        const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
    }

    object KotlinDep {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    }

    object JavaDep {
        const val javax = "javax.inject:javax.inject:${Versions.javaxInjectVersion}"
    }

    object CoreDep {

        const val viewpager2 = "androidx.viewpager2:viewpager2:${Versions.viewpager2Version}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
        const val material = "com.google.android.material:material:${Versions.materialVersion}"
        const val navigationUiKtx =
            "androidx.navigation:navigation-ui-ktx:${Versions.navUiKtxVersion}"
        const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtxVersion}"

        val appLibraries = arrayListOf<String>().apply {
            add(KotlinDep.kotlin)
            add(coreKtx)
            add(appCompat)
            add(material)
            add(navigationUiKtx)
            add(activityKtx)
        }
    }

    object LifeCycleDep {
        const val viewModelKtx =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewmodelKtxVersion}"
        const val lifeCycleRuntime =
            "androidx.lifecycle:lifecycle-runtime:${Versions.lifeCycleRuntimeVersion}"
        const val lifeCycleRuntimeKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycleRuntimeKtxVersion}"
    }

    object CoroutinesDep {
        const val coroutineCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutineCoreVersion}"
        const val coroutineAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineAndroidVersion}"
    }

    object GlideDep {
        const val glide = "com.github.bumptech.glide:compose:1.0.0-beta01"
    }

    object RetrofitDep {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    }

    object RoomDep {
        const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
        const val roomCompilerKapt = "androidx.room:room-compiler:${Versions.roomVersion}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    }

    fun DependencyHandler.implementation(list: List<String>) {
        list.forEach { dependency ->
            add("implementation", dependency)
        }
    }

}
