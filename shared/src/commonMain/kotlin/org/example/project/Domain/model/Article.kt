package org.example.project.domain.model

data class Article(
    val title: String,
    val description: String,
    val imageUrl: String?,
    val publishedAt: String,
    val url: String,
    val isFavorite: Boolean = false
)