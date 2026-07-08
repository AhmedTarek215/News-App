package org.example.project.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleDto(

    val title: String?,

    val description: String?,

    @SerialName("urlToImage")
    val urlToImage: String?,

    val url: String?,

    @SerialName("publishedAt")
    val publishedAt: String?
)
