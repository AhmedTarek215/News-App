package org.example.project.data.remote.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.example.project.data.remote.dto.NewsResponse

class ArticleApi(
    private val client: HttpClient
) {

    companion object {
        private const val BASE_URL = "https://newsapi.org/v2/top-headlines"
        private const val COUNTRY = "us"
        private const val CATEGORY = "business"
        private const val API_KEY = "a7ddd09c62c54b18be0395cb143f8f82"
    }

    suspend fun getArticles(): NewsResponse {

        return client.get(BASE_URL) {

            parameter("country", COUNTRY)

            parameter("category", CATEGORY)

            parameter("apiKey", API_KEY)
        }.body()
    }
}