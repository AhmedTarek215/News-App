package org.example.project.presentation.articles.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.flow.collectLatest
import org.example.project.presentation.articles.components.ArticleCard
import org.example.project.presentation.articles.effect.ArticleEffect
import org.example.project.presentation.articles.intent.ArticleIntent
import org.example.project.presentation.articles.viewmodel.ArticleViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ArticleScreen(
    viewModel: ArticleViewModel = koinViewModel()
) {

    val state by viewModel.state.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    // Collect one-shot effects (Snackbar messages)
    LaunchedEffect(Unit) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                is ArticleEffect.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(effect.message)
                }
            }
        }
    }

    Scaffold(

        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState
            )
        }

    ) { padding ->

        when {

            state.isLoading -> {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }

            }

            state.error != null -> {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = state.error!!,
                        color = MaterialTheme.colorScheme.error
                    )
                }

            }

            else -> {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                ) {

                    items(
                        state.articles,
                        key = { it.url }
                    ) { article ->

                        ArticleCard(

                            article = article,

                            onFavoriteClick = {

                                viewModel.onIntent(
                                    ArticleIntent.ToggleFavorite(article)
                                )

                            }

                        )
                    }
                }

            }
        }
    }
}