package org.example.project.di

import org.example.project.domain.usecase.GetArticlesUseCase
import org.koin.dsl.module

val useCaseModule = module {

    factory {
        GetArticlesUseCase(get())
    }

}