package org.example.project.presentation.articles.effect

sealed interface ArticleEffect {

    data class ShowSnackbar(
        val message: String
    ) : ArticleEffect

}