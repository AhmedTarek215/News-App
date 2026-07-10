package org.example.project.di

import org.example.project.domain.usecase.AddFavoriteUseCase
import org.example.project.domain.usecase.IsFavoriteUseCase
import org.example.project.domain.usecase.RemoveFavoriteUseCase
import org.example.project.domain.usecase.GetArticlesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetArticlesUseCase(get()) }

    factory { AddFavoriteUseCase(get()) }

    factory { RemoveFavoriteUseCase(get()) }

    factory { IsFavoriteUseCase(get()) }
}