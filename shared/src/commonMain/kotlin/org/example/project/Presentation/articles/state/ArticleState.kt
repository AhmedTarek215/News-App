package org.example.project.presentation.articles.state

import org.example.project.domain.model.Article

data class ArticleState(

    val isLoading: Boolean = false,

    val articles: List<Article> = emptyList(),

    val error: String? = null

)