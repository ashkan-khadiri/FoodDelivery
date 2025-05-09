package dependencies

object PresentationDep {
    const val coreKtx = Dependencies.CoreDep.coreKtx
    const val kotlin = Dependencies.KotlinDep.kotlin
    const val javax = Dependencies.JavaDep.javax
    const val coroutineCore = Dependencies.CoroutinesDep.coroutineCore

    val lifeCycle = listOf(
        Dependencies.LifeCycleDep.viewModelKtx,
        Dependencies.LifeCycleDep.lifeCycleRuntime,
        Dependencies.LifeCycleDep.lifeCycleRuntimeKtx
    )
}