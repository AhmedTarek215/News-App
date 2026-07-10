package org.example.project.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

typealias KoinAppDeclaration = KoinApplication.() -> Unit

fun initKoin(
    appDeclaration: KoinAppDeclaration = {}
): KoinApplication {

    return startKoin {

        appDeclaration()

        modules(appModules)

    }

}