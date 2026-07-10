package org.example.project.data.local.mapper

import org.example.project.data.local.entity.FavoriteArticleEntity
import org.example.project.domain.model.Article

fun Article.toEntity() = FavoriteArticleEntity(
    url = url,
    title = title,
    description = description,
    imageUrl = imageUrl,
    publishedAt = publishedAt
)

fun FavoriteArticleEntity.toDomain() = Article(
    url = url,
    title = title,
    description = description,
    imageUrl = imageUrl,
    publishedAt = publishedAt,
    isFavorite = true
)