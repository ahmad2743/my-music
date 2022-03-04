package com.esgi.mymusic.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.esgi.mymusic.*
import com.esgi.mymusic.data.MusicApiManager
import com.esgi.mymusic.domain.CurrentTrendingAlbums
import com.esgi.mymusic.domain.CurrentTrendingSingles
import com.esgi.mymusic.domain.TrendingAlbum
import com.esgi.mymusic.domain.TrendingSingle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class AlbumFragment : Fragment(), AlbumRankingAdapter.onAlbumItemClickListener {
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var myAdapter: AlbumRankingAdapter
    var res: List<TrendingAlbum>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_album, container, false)
        updateView()
        return view
    }

    private fun updateView(){
        GlobalScope.launch(Dispatchers.Default) {
            res = MusicApiManager.getRankingAlbumList("us", "itunes", "singles").trending

            withContext(Dispatchers.Main){
                val recycle = view?.findViewById<RecyclerView>(R.id.ranking_album_recycler_view)
                linearLayoutManager = LinearLayoutManager(context)
                myAdapter = AlbumRankingAdapter(requireContext(), res!!, this@AlbumFragment)
                myAdapter.notifyDataSetChanged()
                recycle!!.adapter = myAdapter
                recycle!!.layoutManager = linearLayoutManager
            }

        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AlbumFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(context, AlbumDetailActivity::class.java)
        val bundle = Bundle()
        bundle.putParcelable("res", res?.get(position))
        intent.putExtra("myBundle", bundle)
        startActivity(intent)
    }
}