package com.esgi.mymusic.domain

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRepository {
    @GET("trending.php")
    fun RankingTracksList(@Query("country") country: String = "us", @Query("type") type: String = "itunes", @Query("format") format: String = "singles") : Deferred<CurrentTrendingSingles>
    @GET("trending.php")
    fun RankingAlbumsList(@Query("country") country: String = "itunes", @Query("type") type: String = "itunes", @Query("format") format: String = "albums") : Deferred<CurrentTrendingAlbums>
    @GET("album.php")
    fun getAlbumsFromArtist(@Query("i") value: String) : Deferred<Album> // i = artist id
    @GET("track-top10-mb.php")
    fun getTopTracksFromArtist(@Query("s") value: String) : Deferred<Tracks> // i = artist name
    @GET("search.php")
    fun artistByName(@Query("s") value: String) : Deferred<Artist>
    @GET("searchalbum.php")
    fun allAlbumsByArtistName( @Query("s")value: String) : Deferred<Album>
    @GET("track.php")
    fun trackById(@Query("h") value: String) : Deferred<Tracks>
    @GET("track.php")
    fun allTracksFromAlbumId(@Query("m") value: String): Deferred<Tracks> //

}