package org.example.project.data.remote.mapper

import org.example.project.data.remote.dto.ArticleDto
import org.example.project.domain.model.Article

fun ArticleDto.toDomain(): Article {

    return Article(
        title = title.orEmpty(),
        description = description.orEmpty(),
        imageUrl = urlToImage,
        publishedAt = publishedAt.orEmpty(),
        url = url.orEmpty(),
        isFavorite = false
    )
}