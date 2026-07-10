package org.example.project.di

import org.example.project.data.repository.ArticleRepositoryImpl
import org.example.project.domain.repository.ArticleRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<ArticleRepository> {

        ArticleRepositoryImpl(

            get(),

            get()

        )

    }

}