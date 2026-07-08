package org.example.project.data.repository

import org.example.project.data.remote.api.ArticleApi
import org.example.project.data.remote.mapper.toDomain
import org.example.project.domain.model.Article
import org.example.project.domain.repository.ArticleRepository

class ArticleRepositoryImpl(
    private val api: ArticleApi
) : ArticleRepository {

    override suspend fun getArticles(): List<Article> {
        return api.getArticles().articles.map { it.toDomain() }
    }
}