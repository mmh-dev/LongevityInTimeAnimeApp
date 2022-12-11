package com.mmh.longevityintimeanimeapp.network

import com.mmh.longevityintimeanimeapp.domain.model.AnimeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface AnimeApi {

    @Headers("X-RapidAPI-Key: 167a2ef0cdmshdd57af5cc5f5c37p1ec393jsn70b5a79f8c6e",
        "X-RapidAPI-Host: anime-db.p.rapidapi.com")

    @GET("anime")
    suspend fun getAnimes(
        @Query("page") page: String,
        @Query("size") size: String,
    ): Response<AnimeResponse>
}