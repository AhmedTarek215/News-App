package org.example.project.data.local.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import org.example.project.data.local.dao.FavoriteDao
import org.example.project.data.local.entity.FavoriteArticleEntity

@Database(
    entities = [FavoriteArticleEntity::class],
    version = 1,
    exportSchema = true
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao
}