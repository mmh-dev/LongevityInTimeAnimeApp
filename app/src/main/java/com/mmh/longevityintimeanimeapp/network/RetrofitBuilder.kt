package com.mmh.longevityintimeanimeapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val builder = Retrofit.Builder()
        .baseUrl("https://anime-db.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = builder.create(AnimeApi::class.java)
}