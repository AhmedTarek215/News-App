package org.example.project.presentation.articles.intent

sealed interface ArticleIntent {

    data object LoadArticles : ArticleIntent

}