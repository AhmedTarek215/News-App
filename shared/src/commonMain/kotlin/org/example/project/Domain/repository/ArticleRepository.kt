package org.example.project.domain.repository

import kotlinx.coroutines.flow.Flow
import org.example.project.domain.model.Article

interface ArticleRepository {

    suspend fun getArticles(): List<Article>

    fun getFavorites(): Flow<List<Article>>

    suspend fun addFavorite(article: Article)

    suspend fun removeFavorite(article: Article)

    suspend fun isFavorite(url: String): Boolean
}