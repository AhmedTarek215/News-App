package org.example.project.domain.usecase

import org.example.project.domain.repository.ArticleRepository

class GetArticlesUseCase(
    private val repository: ArticleRepository
) {

    suspend operator fun invoke() =
        repository.getArticles()
}