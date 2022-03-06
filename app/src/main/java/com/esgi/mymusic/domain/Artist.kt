package com.esgi.mymusic.domain

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Artist(
    val artists: List<ArtistDetail>
) : Parcelable