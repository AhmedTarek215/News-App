package org.example.project.data.local.database

import androidx.room.RoomDatabaseConstructor

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<ArticleDatabase> {
    override fun initialize(): ArticleDatabase
}