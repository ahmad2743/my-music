package com.esgi.mymusic.domain

import retrofit2.Call
import retrofit2.http.GET

interface ApiRepository {
    @GET("")
    fun getRankingTracksList() : Call<ArrayList<TrendingSingle>>
    @GET("")
    fun getRankingAlbumsList() : Call<ArrayList<TrendingAlbum>>
    @GET("")
    fun getAlbumsFromArtist(value: String) : Call<ArrayList<AlbumsAndYearsRelease>>
    @GET("")
    fun getTopTracksFromArtist(value: String) : Call<ArrayList<Track>>
    @GET("")
    fun searchArtistByName(value: String) : Call<ArtistDetail>
    @GET("")
    fun searchAlbumByName(value: String) : Call<SingleAlbumDetail>
    @GET("")
    fun searchTrackByName(value: String) : Call<Track>

}