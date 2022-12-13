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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import com.mmh.longevityintimeanimeapp.R
import com.mmh.longevityintimeanimeapp.domain.model.Anime

@Composable
fun AnimeCard(
    anime: Anime,
    onClick: () -> Unit = {},
) {
    Card(shape = MaterialTheme.shapes.medium, modifier = Modifier
        .padding(all = 6.dp)
        .fillMaxSize()
        .clickable(onClick = onClick), elevation = 8.dp) {
        Column {

            Image(painter = rememberAsyncImagePainter(model = anime.image,
                imageLoader = ImageLoader.Builder(context = LocalContext.current).crossfade(true).build(),
                placeholder = painterResource(id = R.drawable.ic_baseline_image_24)),
                modifier = Modifier.fillMaxWidth().height(225.dp),
                contentScale = ContentScale.Crop,
                contentDescription = "anime poster")

            Text(text = anime.title,
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .align(Alignment.CenterHorizontally)
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(all = 4.dp),
                style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center)
        }
    }
}