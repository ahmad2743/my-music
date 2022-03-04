package com.esgi.mymusic.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class TrendingAlbum(
    val dateAdded: String?,
    val idAlbum: String?,
    val idArtist: String?,
    val idTrack: @RawValue Any?,
    val idTrend: String?,
    val intChartPlace: String?,
    val intWeek: String?,
    val strAlbum: String?,
    val strAlbumMBID: String?,
    val strAlbumThumb: String?,
    val strArtist: String?,
    val strArtistMBID: String?,
    val strArtistThumb: String?,
    val strCountry: String?,
    val strTrack: @RawValue Any?,
    val strTrackMBID: @RawValue Any?,
    val strTrackThumb: @RawValue Any?,
    val strType: String?
): Parcelable