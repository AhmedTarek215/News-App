package org.example.project.data.local.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import platform.Foundation.NSHomeDirectory

actual class DatabaseFactory {

    actual fun createDatabase(): ArticleDatabase {

        val dbFilePath = NSHomeDirectory() + "/articles.db"

        return Room.databaseBuilder<ArticleDatabase>(
            name = dbFilePath
        )
            .setDriver(BundledSQLiteDriver())
            .build()

    }

}