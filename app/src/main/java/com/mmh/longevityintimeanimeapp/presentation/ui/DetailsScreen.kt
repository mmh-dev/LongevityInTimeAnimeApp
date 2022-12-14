package com.mmh.longevityintimeanimeapp.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.mmh.longevityintimeanimeapp.domain.model.Anime
import com.mmh.longevityintimeanimeapp.presentation.components.Screen
import com.mmh.longevityintimeanimeapp.presentation.theme.Main
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailsScreen(id: String?, viewModel: AnimeViewModel) {

    val anime: Anime? = viewModel.animeList.firstOrNull { it._id == id }
    val state = rememberCollapsingToolbarScaffoldState()
    val textSize = (18 + (30 - 12) * state.toolbarState.progress).sp

    if (anime != null) {
        CollapsingToolbarScaffold(modifier = Modifier, state = state, scrollStrategy = ScrollStrategy.ExitUntilCollapsed, toolbar = {
            Box(modifier = Modifier
                .fillMaxSize()
                .height(150.dp)
                .pin()
                .background(color = Main))

            Image(painter = rememberAsyncImagePainter(model = ImageRequest.Builder(LocalContext.current).data(anime.image).size(Size.ORIGINAL)
                .build()),
                modifier = Modifier
                    .fillMaxSize()
                    .height(225.dp),
                contentScale = ContentScale.Crop,
                alpha = if (textSize.value <= 20f) 0f else 1f,
                contentDescription = "anime poster")

            Text(text = anime.title,
                style = TextStyle(color = Color.White, fontSize = textSize),
                modifier = Modifier
                    .padding(16.dp)
                    .road(whenCollapsed = Alignment.TopStart, whenExpanded = Alignment.BottomStart))

        }) {
            Box(modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(all = 16.dp)) {
                Column {
                    Row() {
                        Column(modifier = Modifier
                            .padding(vertical = 8.dp)
                            .fillMaxWidth(0.5f)) {
                            Row(modifier = Modifier.padding(vertical = 8.dp)) {
                                Text(text = "Title: ")
                                Text(text = anime.title)
                            }
                            Row(modifier = Modifier.padding(vertical = 8.dp)) {
                                Text(text = "Type: ")
                                Text(text = anime.type)
                            }
                            Row(modifier = Modifier.padding(vertical = 8.dp)) {
                                Text(text = "Ranking: ")
                                Text(text = anime.ranking.toString())
                            }
                            Row(modifier = Modifier.padding(vertical = 8.dp)) {
                                Text(text = "Status: ")
                                Text(text = anime.status)
                            }
                            Row(modifier = Modifier.padding(vertical = 8.dp)) {
                                Text(text = "Episodes: ")
                                Text(text = anime.episodes.toString())
                            }
                        }
                        Column(modifier = Modifier
                            .padding(all = 8.dp)) {
                            Text(text = "Genres",
                                modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .align(Alignment.Start),
                                style = MaterialTheme.typography.body2
                            )
                            for(i in anime.genres) {
                                Chip(onClick = { /*TODO*/ }) {
                                    Text(text = i)
                                }
                            }
                        }
                    }
                    Text(text = "Synopsis",
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .align(Alignment.CenterHorizontally),
                        style = MaterialTheme.typography.h6)
                    Text(text = anime.synopsis)
                }
            }

        }
    }
}