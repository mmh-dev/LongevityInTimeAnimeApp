package com.mmh.longevityintimeanimeapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mmh.longevityintimeanimeapp.R
import com.mmh.longevityintimeanimeapp.domain.model.Anime

@Composable
fun AnimeCard(
    anime: Anime,
    onClick: () -> Unit = {},
) {
    Card(shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(bottom = 6.dp, top = 6.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp) {
        Column() {
            anime.image?.let { url ->
                Image(painter = painterResource(id = R.drawable.ic_baseline_image_24),
                    contentDescription = "Anime poster",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(225.dp),
                    contentScale = ContentScale.Crop)
            }
            anime.title?.let { title ->
                Text(text = title,
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp),
                    style = MaterialTheme.typography.h5)
            }
        }
    }
}