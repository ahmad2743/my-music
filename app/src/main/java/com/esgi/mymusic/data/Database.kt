package com.esgi.mymusic.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.esgi.mymusic.domain.ArtistDetail
import com.esgi.mymusic.domain.FavorisDAO

private const val DATABASE_VERSION = 1

@Database(entities = [ArtistDetail::class], version = DATABASE_VERSION)
abstract class Database : RoomDatabase() {
    abstract fun artistDetailDao(): FavorisDAO
}