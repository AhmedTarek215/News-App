package org.example.project.di

import org.example.project.presentation.articles.viewmodel.ArticleViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        ArticleViewModel(get())
    }

}