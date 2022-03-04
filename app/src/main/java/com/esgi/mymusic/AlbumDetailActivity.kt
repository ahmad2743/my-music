package com.esgi.mymusic

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.esgi.mymusic.data.MusicApiManager.Companion.getAlbumInfos
import com.esgi.mymusic.data.MusicApiManager.Companion.getAllTrackFromAlbumId
import com.esgi.mymusic.domain.Album
import com.esgi.mymusic.domain.Tracks
import com.esgi.mymusic.domain.TrendingAlbum
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class AlbumDetailActivity : AppCompatActivity() {
    var titles: Tracks? = null
    var albumInfo: Album? = null
    var linearLayoutManager: LinearLayoutManager? = null
    var albumTitle: TextView? = null
    var artist: TextView? = null
    var nbSong : TextView? = null
    var votes: TextView? = null
    var desc: TextView? = null
    var img: ImageView? = null
    var img_bg: ImageView? = null

    var bgImg: View? = null

    // val albumTitle = findViewById<TextView>(R.id.album_title)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_detail2)
        updateView()

    }
    private fun updateView(){
        albumTitle = findViewById(R.id.artist_name_des)
        artist = findViewById<TextView>(R.id.artist_name_ab)
        nbSong = findViewById<TextView>(R.id.type_desc)
        votes = findViewById<TextView>(R.id.nb_votes)
        desc = findViewById<TextView>(R.id.description_artist)
        img = findViewById(R.id.image_album_fw)
        img_bg = findViewById(R.id.image_bg_artist)

        bgImg = findViewById(R.id.image_bg_album)
        val bundle = intent.getBundleExtra("myBundle")
        val res = bundle?.getParcelable<TrendingAlbum>("res")
        GlobalScope.launch(Dispatchers.Default) {
            titles = getAllTrackFromAlbumId(res?.idAlbum.toString())
            albumInfo = getAlbumInfos(res?.idAlbum.toString())

            withContext(Dispatchers.Main){
                albumTitle?.text = albumInfo?.album?.last()?.strAlbum.toString()
                artist?.text = albumInfo?.album?.last()?.strArtist.toString()
                nbSong?.text = titles?.track?.size.toString() + " chansons"
                desc?.text = albumInfo?.album?.last()?.strDescriptionEN.toString()
                votes?.text = albumInfo?.album?.last()?.intScoreVotes.toString() + " votes"
                Picasso.get().load(albumInfo?.album?.last()?.strAlbumThumb.toString()).into(img)
                Picasso.get().load(albumInfo?.album?.last()?.strAlbumThumb.toString()).into(img_bg)
                img_bg?.alpha = 0.5f



                val recycle = findViewById<RecyclerView>(R.id.myTopSongListView)
                linearLayoutManager = LinearLayoutManager(applicationContext)
                var myAdapter = ListViewAdapter(applicationContext, titles!!.track)
                myAdapter.notifyDataSetChanged()
                recycle!!.adapter = myAdapter
                recycle!!.layoutManager = linearLayoutManager











        }
        }
    }
}