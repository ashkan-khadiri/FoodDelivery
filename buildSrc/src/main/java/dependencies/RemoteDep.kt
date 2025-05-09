package dependencies

object RemoteDep {
    const val coreKtx = Dependencies.CoreDep.coreKtx
    const val kotlin = Dependencies.KotlinDep.kotlin
    const val javax = Dependencies.JavaDep.javax
    val retrofit = listOf(
        Dependencies.RetrofitDep.retrofit,
    )
    const val coroutineCore = Dependencies.CoroutinesDep.coroutineCore
}