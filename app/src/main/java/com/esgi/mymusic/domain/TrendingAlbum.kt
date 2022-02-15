package com.esgi.mymusic.domain

data class TrendingAlbum(
    val dateAdded: String,
    val idAlbum: String,
    val idArtist: String,
    val idTrack: Any,
    val idTrend: String,
    val intChartPlace: String,
    val intWeek: String,
    val strAlbum: String,
    val strAlbumMBID: String,
    val strAlbumThumb: String,
    val strArtist: String,
    val strArtistMBID: String,
    val strArtistThumb: String,
    val strCountry: String,
    val strTrack: Any,
    val strTrackMBID: Any,
    val strTrackThumb: Any,
    val strType: String
)