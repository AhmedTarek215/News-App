package org.example.project.di

import org.example.project.data.remote.api.ArticleApi
import org.example.project.data.remote.api.createHttpClient
import org.koin.dsl.module

val networkModule = module {

    single {
        createHttpClient()
    }

    single {
        ArticleApi(get())
    }
}