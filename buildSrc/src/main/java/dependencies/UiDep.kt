package dependencies

object UiDep {

    const val gson = Dependencies.Google.gson

    const val viewpager2 = Dependencies.CoreDep.viewpager2

    // Kotlin
    const val kotlin = Dependencies.KotlinDep.kotlin

    // Core
    const val coreKtx = Dependencies.CoreDep.coreKtx
    const val appCompat = Dependencies.CoreDep.appCompat
    const val material = Dependencies.CoreDep.material
        const val navigationUiKtx = Dependencies.CoreDep.navigationUiKtx
    const val activityKtx = Dependencies.CoreDep.activityKtx

    // LifeCycle
    val LifeCycle = listOf(
        Dependencies.LifeCycleDep.viewModelKtx,
        Dependencies.LifeCycleDep.lifeCycleRuntime,
        Dependencies.LifeCycleDep.lifeCycleRuntimeKtx
    )

    // Coroutines
    val Coroutines = listOf(
        Dependencies.CoroutinesDep.coroutineCore,
        Dependencies.CoroutinesDep.coroutineAndroid
    )

    const val glide = Dependencies.GlideDep.glide
    const val retrofit = Dependencies.RetrofitDep.retrofit
}