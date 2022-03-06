package com.esgi.mymusic.data

import android.provider.MediaStore
import com.esgi.mymusic.domain.*
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MusicApiManager {

    companion  object{

        private val BASE_URL = "https://theaudiodb.com/api/v1/json/523532/"
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(ApiRepository::class.java)

        suspend fun getRankingTracksList(county: String, type: String, format: String): CurrentTrendingSingles {
            return retrofitBuilder.RankingTracksList(county, type, format).await()
        }

        suspend fun getRankingAlbumList(county: String, type: String, format: String): CurrentTrendingAlbums {
            return retrofitBuilder.RankingAlbumsList(county, type, format).await()

        }

        suspend fun getAlbumFromArtistId(id: String) : Album {
            return retrofitBuilder.getAlbumsFromArtist(id).await()
        }

        suspend fun getTopTracksFromArtisName(name: String) : Tracks {
            return retrofitBuilder.getTopTracksFromArtist(name).await()
        }

        suspend fun getArtistByName(name: String) : Artist {
            return  retrofitBuilder.artistByName(name).await()
        }
        suspend fun getArtistById(id: String) : Artist {
            return retrofitBuilder.getArtistById(id).await()
        }

        suspend fun getAllAlbumFromArtisName(name: String) : Album {
            return retrofitBuilder.allAlbumsByArtistName(name).await()
        }

        suspend fun getTrackById(id: String) : Tracks {
            return retrofitBuilder.trackById(id).await()
        }

        suspend fun getAllTrackFromAlbumId(id: String) : Tracks {
            return retrofitBuilder.allTracksFromAlbumId(id).await()
        }
        suspend fun getAlbumInfos(id: String) : Album {
            return retrofitBuilder.getAlbumInformations(id).await()
        }
    }
}

