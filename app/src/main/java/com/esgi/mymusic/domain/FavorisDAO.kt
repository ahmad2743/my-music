package com.esgi.mymusic.domain

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FavorisDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addArtist(artist: ArtistDetail)

    @Update
    fun updateArtist(artist: ArtistDetail)

    @Delete
    fun deleteArtist(artist: ArtistDetail)

    @Query("SELECT * FROM ArtistDetail")
    fun listArtists() : Flow<List<ArtistDetail>>
}