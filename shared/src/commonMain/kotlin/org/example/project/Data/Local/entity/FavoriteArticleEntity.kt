package org.example.project.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class FavoriteArticleEntity(

    @PrimaryKey
    val url: String,

    val title: String,

    val description: String,

    val imageUrl: String?,

    val publishedAt: String
)