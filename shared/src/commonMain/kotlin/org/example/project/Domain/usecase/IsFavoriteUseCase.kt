package org.example.project.domain.usecase

import org.example.project.domain.repository.ArticleRepository

class IsFavoriteUseCase(
    private val repository: ArticleRepository
) {

    suspend operator fun invoke(url: String) =
        repository.isFavorite(url)

}