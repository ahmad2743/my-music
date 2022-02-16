package com.esgi.mymusic.data

import android.util.Log
import android.widget.TextView
import com.esgi.mymusic.R
import com.esgi.mymusic.domain.*
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

class MusicApiManager {




    companion  object{

        private val BASE_URL = "https://theaudiodb.com/api/v1/json/523532/"
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(ApiRepository::class.java)

        suspend fun getRankingTracksLists(county: String, type: String, format: String): CurrentTrendingSingles {
            return retrofitBuilder.getRankingTracksList(county, type, format).await()

        }
    }
    }

