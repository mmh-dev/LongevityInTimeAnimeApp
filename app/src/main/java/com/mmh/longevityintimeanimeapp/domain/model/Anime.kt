package com.mmh.longevityintimeanimeapp.domain.model

data class Anime(
    val _id: String,
    val alternativeTitles: List<String>,
    val episodes: Int,
    val genres: List<String>,
    val hasEpisode: Boolean,
    val hasRanking: Boolean,
    val image: String,
    val link: String,
    val ranking: Int,
    val status: String,
    val synopsis: String,
    val thumb: String,
    val title: String,
    val type: String
)