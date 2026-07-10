package org.example.project.data.repository

import org.example.project.data.remote.api.ArticleApi
import org.example.project.data.remote.mapper.toDomain
import org.example.project.domain.model.Article
import org.example.project.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.map
import org.example.project.data.local.dao.FavoriteDao
import org.example.project.data.local.mapper.toDomain
import org.example.project.data.local.mapper.toEntity

class ArticleRepositoryImpl(
    private val api: ArticleApi,
    private val dao: FavoriteDao
) : ArticleRepository {

    override suspend fun getArticles(): List<Article> {

        return api.getArticles()
            .articles
            .map { dto ->

                val article = dto.toDomain()

                article.copy(
                    isFavorite = dao.isFavorite(article.url)
                )

            }

    }

    override fun getFavorites() =
        dao.getFavorites().map { list ->
            list.map { it.toDomain() }
        }

    override suspend fun addFavorite(article: Article) {
        dao.insert(article.toEntity())
    }

    override suspend fun removeFavorite(article: Article) {
        dao.deleteByUrl(article.url)
    }

    override suspend fun isFavorite(url: String): Boolean {
        return dao.isFavorite(url)
    }
}