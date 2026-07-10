package org.example.project.di

import org.example.project.data.local.database.DatabaseFactory
import org.koin.dsl.module

actual val platformModule = module {
    single { DatabaseFactory() }
}
