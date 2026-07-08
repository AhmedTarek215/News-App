package org.example.project.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(

    val status: String,

    val totalResults: Int,

    val articles: List<ArticleDto>
)
