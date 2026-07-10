package org.example.project.data.local.database



expect class DatabaseFactory {

    fun createDatabase(): ArticleDatabase

}