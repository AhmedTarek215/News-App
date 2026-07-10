package org.example.project.data.local.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

actual class DatabaseFactory(
    private val context: Context
) {

    actual fun createDatabase(): ArticleDatabase {

        return Room.databaseBuilder<ArticleDatabase>(
            context = context,
            name = "articles.db"
        )
            .setDriver(BundledSQLiteDriver())
            .build()

    }

}