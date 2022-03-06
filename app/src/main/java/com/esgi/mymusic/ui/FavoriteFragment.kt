package com.esgi.mymusic.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.esgi.mymusic.FavoriteArtistsAdapter
import com.esgi.mymusic.R
import com.esgi.mymusic.data.Database
import com.esgi.mymusic.data.DatabaseManager
import com.esgi.mymusic.domain.Artist
import com.esgi.mymusic.domain.ArtistDetail

class FavoriteFragment : Fragment(), FavoriteArtistsAdapter.ArtistItemListener {

    interface FavoriteFragmentListener {
        fun onArtistSelected(artist: ArtistDetail)
    }

    var listener: FavoriteFragmentListener? = null
    //val databaseManager = DatabaseManager()

    private lateinit var artists: List<ArtistDetail>
    private lateinit var linearLayout: LinearLayout
    private lateinit var adapter: FavoriteArtistsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //artists = mutableListOf() //empty
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorite, container, false)
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FavoriteFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onArtistSelected(artist: ArtistDetail) {
        TODO("Not yet implemented")
    }
}