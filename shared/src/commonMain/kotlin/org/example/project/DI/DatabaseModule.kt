package org.example.project.di

import org.example.project.data.local.database.DatabaseFactory
import org.koin.dsl.module

val databaseModule = module {

    single {
        get<DatabaseFactory>().createDatabase()
    }

    single {
        get<org.example.project.data.local.database.ArticleDatabase>().favoriteDao()
    }

}
