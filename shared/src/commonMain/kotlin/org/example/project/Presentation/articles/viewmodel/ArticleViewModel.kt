package org.example.project.presentation.articles.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.example.project.domain.usecase.GetArticlesUseCase
import org.example.project.presentation.articles.intent.ArticleIntent
import org.example.project.presentation.articles.state.ArticleState

class ArticleViewModel(
    private val getArticlesUseCase: GetArticlesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ArticleState())
    val state = _state.asStateFlow()

    init {
        onIntent(ArticleIntent.LoadArticles)
    }

    fun onIntent(intent: ArticleIntent) {

        when (intent) {

            ArticleIntent.LoadArticles -> loadArticles()

        }

    }

    private fun loadArticles() {

        viewModelScope.launch {

            _state.value = _state.value.copy(
                isLoading = true
            )

            try {

                val articles = getArticlesUseCase()

                _state.value = _state.value.copy(
                    isLoading = false,
                    articles = articles
                )

            } catch (e: Exception) {

                e.printStackTrace()

                _state.value = _state.value.copy(
                    isLoading = false,
                    error = e.message
                )

            }

        }

    }

}