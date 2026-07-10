package org.example.project.presentation.articles.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.example.project.presentation.articles.viewmodel.ArticleViewModel
import org.koin.compose.viewmodel.koinViewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import org.example.project.presentation.articles.components.ArticleCard

@Composable
fun ArticleScreen(
    viewModel: ArticleViewModel = koinViewModel()
) {

    val state by viewModel.state.collectAsState()

    when {

        state.isLoading -> {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }

        }

        state.error != null -> {

            Box(
                modifier = Modifier.fillMaxSize(),
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
                modifier = Modifier.fillMaxSize()
            ) {

                items(state.articles) { article ->

                    ArticleCard(
                        article = article,
                        onFavoriteClick = {


                        }
                    )

                }

            }

        }

    }

}