package com.esgi.mymusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.esgi.mymusic.domain.Album
import com.esgi.mymusic.domain.ArtistDetail
import com.esgi.mymusic.domain.Tracks

class ArtistDetailActivity : AppCompatActivity() {
    var titles: Tracks? = null
    var albums: Album? = null
    var linearLayoutManager: LinearLayoutManager? = null
    var artistName: TextView? = null
    var etc : TextView? = null
    var nbAlbums: TextView? = null
    var artistDesc: TextView? = null
    var img: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_detail)
        updateView()
    }

    private fun updateView(){
        val bundle = intent.getBundleExtra("myBundle")
        val res = bundle?.getParcelable<ArtistDetail>("res")
        vText.text = res?.strArtist
    }
}