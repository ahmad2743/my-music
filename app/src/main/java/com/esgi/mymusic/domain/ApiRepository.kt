package com.esgi.mymusic.domain

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRepository {
    @GET("trending.php")
    fun getRankingTracksList(@Query("country") country: String = "us", @Query("type") type: String = "itunes", @Query("format") format: String = "singles") : Deferred<CurrentTrendingSingles>
    @GET("trending.php")
    fun getRankingAlbumsList(@Query("country") country: String = "itunes", @Query("type") type: String = "itunes", @Query("format") format: String = "albums") : Deferred<ArrayList<CurrentTrendingAlbums>>
    @GET("album.php")
    fun getAlbumsFromArtist(@Query("i") value: String) : Deferred<Album>
    @GET("track-top10-mb.php")
    fun getTopTracksFromArtist(@Query("s") value: String) : Deferred<Tracks>
    @GET("search.php")
    fun getArtistByName(@Query("s") value: String) : Deferred<Artist>
    @GET("searchalbum.php")
    fun getAllAlbumsByArtistName( @Query("s")value: String) : Deferred<Album>
    @GET("track.php")
    fun getTrackById(@Query("h") value: String) : Deferred<Tracks>
    @GET("track.php")
    fun getAllTracksFromAlbum(@Query("m") value: String): Deferred<Tracks>

}