package com.esgi.mymusic.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.esgi.mymusic.AlbumRankingAdapter
import com.esgi.mymusic.R
import com.esgi.mymusic.RankingAdapter
import com.esgi.mymusic.data.MusicApiManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class AlbumFragment : Fragment() {
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var myAdapter: AlbumRankingAdapter

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
            val res = MusicApiManager.getRankingAlbumList("us", "itunes", "singles").trending

            withContext(Dispatchers.Main){
                val recycle = view?.findViewById<RecyclerView>(R.id.ranking_album_recycler_view)
                linearLayoutManager = LinearLayoutManager(context)
                myAdapter = AlbumRankingAdapter(requireContext(), res)
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
}