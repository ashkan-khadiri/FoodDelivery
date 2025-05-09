object Modules {
    const val core = ":core" // domain models layer independent
    const val data = ":data" // database implemented classes layer depends on shared only
    const val network = ":network" // remote implemented classes layer depends on shared only
    const val presentation = ":presentation" //mvvm layer depends on core only
    const val ui = ":app" // depends on all modules
}