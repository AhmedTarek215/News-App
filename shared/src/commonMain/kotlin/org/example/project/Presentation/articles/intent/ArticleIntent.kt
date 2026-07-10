package org.example.project.presentation.articles.intent

import org.example.project.domain.model.Article

sealed interface ArticleIntent {

    data object LoadArticles : ArticleIntent

    data class ToggleFavorite(
        val article: Article
    ) : ArticleIntent
}