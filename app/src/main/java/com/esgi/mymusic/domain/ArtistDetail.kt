package com.esgi.mymusic.domain

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
@Entity
data class ArtistDetail(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val idArtist: String,
    val idLabel: String?,
    val intBornYear: String?,
    val intCharted: String?,
    val intDiedYear: String?,
    val intFormedYear: String?,
    val intMembers: String?,
    val strArtist: String?,
    val strArtistAlternate: String?,
    val strArtistBanner: String?,
    val strArtistClearart: String?,
    val strArtistCutout: String?,
    val strArtistFanart: String?,
    val strArtistFanart2: String?,
    val strArtistFanart3: String?,
    val strArtistFanart4: String?,
    val strArtistLogo: String?,
    val strArtistStripped: String?,
    val strArtistThumb: String?,
    val strArtistWideThumb: String?,
    val strBiographyCN: String?,
    val strBiographyDE: String?,
    val strBiographyEN: String?,
    val strBiographyES: String?,
    val strBiographyFR: String?,
    val strBiographyHU: String?,
    val strBiographyIL: String?,
    val strBiographyIT: String?,
    val strBiographyJP: String?,
    val strBiographyNL: String?,
    val strBiographyNO: String?,
    val strBiographyPL: String?,
    val strBiographyPT: String?,
    val strBiographyRU: String?,
    val strBiographySE: String?,
    val strCountry: String?,
    val strCountryCode: String?,
    val strDisbanded: String?,
    val strFacebook: String?,
    val strGender: String?,
    val strGenre: String?,
    val strISNIcode: String?,
    val strLabel: String?,
    val strLastFMChart: String?,
    val strLocked: String?,
    val strMood: String?,
    val strMusicBrainzID: String?,
    val strStyle: String?,
    val strTwitter: String?,
    val strWebsite: String?
) : Parcelable