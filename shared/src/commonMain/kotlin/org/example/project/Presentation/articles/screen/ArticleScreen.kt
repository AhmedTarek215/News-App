package org.example.project.presentation.articles.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel
import org.example.project.presentation.articles.viewmodel.ArticleViewModel

@Composable
fun ArticleScreen(

    viewModel: ArticleViewModel = koinViewModel()

) {

    val state by viewModel.state.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        if (state.isLoading) {

            CircularProgressIndicator()

        }

    }

}