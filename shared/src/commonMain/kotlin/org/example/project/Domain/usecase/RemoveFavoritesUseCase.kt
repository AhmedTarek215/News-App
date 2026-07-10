package org.example.project.domain.usecase

import org.example.project.domain.model.Article
import org.example.project.domain.repository.ArticleRepository

class RemoveFavoriteUseCase(
    private val repository: ArticleRepository
) {

    suspend operator fun invoke(article: Article) {
        repository.removeFavorite(article)
    }

}