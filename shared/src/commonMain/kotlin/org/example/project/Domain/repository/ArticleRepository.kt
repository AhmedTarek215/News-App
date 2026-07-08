package org.example.project.domain.repository

import org.example.project.domain.model.Article

interface ArticleRepository {

    suspend fun getArticles(): List<Article>
}