package com.esgi.mymusic.domain

data class TrendingSingle(
    val dateAdded: String,
    val idAlbum: String,
    val idArtist: String,
    val idTrack: String,
    val idTrend: String,
    val intChartPlace: String,
    val intWeek: String,
    val strAlbum: String,
    val strAlbumMBID: String,
    val strAlbumThumb: Any,
    val strArtist: String,
    val strArtistMBID: String,
    val strArtistThumb: Any,
    val strCountry: String,
    val strTrack: String,
    val strTrackMBID: String,
    val strTrackThumb: String,
    val strType: String
)