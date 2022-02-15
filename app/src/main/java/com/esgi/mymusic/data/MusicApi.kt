package com.esgi.mymusic.data

import com.esgi.mymusic.domain.ApiRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MusicApi {

    private val BASE_URL = "theaudiodb.com/api/v1/json/{apikey}/"

    val retrofitBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create(ApiRepository::class.java)
}