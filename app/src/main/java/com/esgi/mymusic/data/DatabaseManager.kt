package com.esgi.mymusic.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.esgi.mymusic.R
import com.esgi.mymusic.domain.ArtistDetail
import kotlinx.coroutines.flow.Flow

abstract class DatabaseManager(context: Context) {

    private val db = Room.databaseBuilder(
        context,
        Database::class.java, "db.sqlite",
    ).build()

    fun addArtist(artist: ArtistDetail) {
        return db.artistDetailDao().addArtist(artist)
    }

    fun updateArtist(artist: ArtistDetail) {
        return db.artistDetailDao().updateArtist(artist)
    }

    fun deleteArtist(artist: ArtistDetail) {
        return db.artistDetailDao().deleteArtist(artist)
    }

    suspend fun listenToArtistsChanges(): Flow<List<ArtistDetail>> {
        return db.artistDetailDao().listArtists()
    }
}