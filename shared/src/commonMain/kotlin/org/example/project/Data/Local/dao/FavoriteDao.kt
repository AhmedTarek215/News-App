package org.example.project.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import org.example.project.data.local.entity.FavoriteArticleEntity

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favorites")
    fun getFavorites(): Flow<List<FavoriteArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: FavoriteArticleEntity)

    @Delete
    suspend fun delete(article: FavoriteArticleEntity)

    @Query("DELETE FROM favorites WHERE url = :url")
    suspend fun deleteByUrl(url: String)

    @Query("SELECT EXISTS(SELECT 1 FROM favorites WHERE url = :url)")
    suspend fun isFavorite(url: String): Boolean
}