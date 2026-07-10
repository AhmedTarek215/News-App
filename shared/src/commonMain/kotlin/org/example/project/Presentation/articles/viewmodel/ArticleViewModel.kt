package org.example.project.presentation.articles.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.example.project.domain.usecase.AddFavoriteUseCase
import org.example.project.domain.usecase.RemoveFavoriteUseCase
import org.example.project.domain.usecase.GetArticlesUseCase
import org.example.project.presentation.articles.intent.ArticleIntent
import org.example.project.presentation.articles.state.ArticleState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import org.example.project.domain.model.Article
import org.example.project.presentation.articles.effect.ArticleEffect

class ArticleViewModel(
    private val getArticlesUseCase: GetArticlesUseCase,
    private val addFavoriteUseCase: AddFavoriteUseCase,
    private val removeFavoriteUseCase: RemoveFavoriteUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ArticleState())
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<ArticleEffect>()
    val effect = _effect.asSharedFlow()

    init {
        onIntent(ArticleIntent.LoadArticles)
    }

    fun onIntent(intent: ArticleIntent) {

        when (intent) {

            ArticleIntent.LoadArticles ->
                loadArticles()

            is ArticleIntent.ToggleFavorite ->
                toggleFavorite(intent.article)

        }

    }

    private fun toggleFavorite(article: Article) {

        viewModelScope.launch {

            try {

                if (article.isFavorite) {

                    removeFavoriteUseCase(article)

                    // Optimistically update the article in the list
                    _state.update { currentState ->
                        currentState.copy(
                            articles = currentState.articles.map {
                                if (it.url == article.url) it.copy(isFavorite = false) else it
                            }
                        )
                    }

                    _effect.emit(
                        ArticleEffect.ShowSnackbar(
                            "Removed from favorites"
                        )
                    )

                } else {

                    addFavoriteUseCase(article)

                    // Optimistically update the article in the list
                    _state.update { currentState ->
                        currentState.copy(
                            articles = currentState.articles.map {
                                if (it.url == article.url) it.copy(isFavorite = true) else it
                            }
                        )
                    }

                    _effect.emit(
                        ArticleEffect.ShowSnackbar(
                            "Added to favorites"
                        )
                    )

                }

            } catch (e: Exception) {

                _effect.emit(
                    ArticleEffect.ShowSnackbar(
                        "Failed to update favorite"
                    )
                )

            }

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