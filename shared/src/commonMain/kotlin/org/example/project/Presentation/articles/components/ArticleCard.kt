package org.example.project.presentation.articles.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.example.project.domain.model.Article

@Composable
fun ArticleCard(
    article: Article,
    onFavoriteClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(16.dp)
    ) {

        Column {

            AsyncImage(
                model = article.imageUrl,
                contentDescription = article.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.height(10.dp))

            Text(
                article.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 12.dp)
            )

            Spacer(Modifier.height(6.dp))

            Text(
                article.description,
                modifier = Modifier.padding(horizontal = 12.dp),
                maxLines = 3
            )

            Spacer(Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    article.publishedAt.take(10)
                )

                IconButton(
                    onClick = onFavoriteClick
                ) {

                    Icon(

                        imageVector =
                            if(article.isFavorite)
                                Icons.Default.Favorite
                            else
                                Icons.Outlined.FavoriteBorder,

                        contentDescription = null,

                        tint =
                            if(article.isFavorite)
                                Color.Red
                            else
                                MaterialTheme.colorScheme.onSurface

                    )
                }

            }

        }

    }

}