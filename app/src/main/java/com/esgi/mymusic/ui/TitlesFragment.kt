package com.esgi.mymusic.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.esgi.mymusic.ArtistDetailActivity
import com.esgi.mymusic.R
import com.esgi.mymusic.RankingAdapter
import com.esgi.mymusic.data.MusicApiManager
import com.esgi.mymusic.data.MusicApiManager.Companion.getArtistById
import com.esgi.mymusic.data.MusicApiManager.Companion.getRankingTracksList
import com.esgi.mymusic.domain.ArtistDetail
import com.esgi.mymusic.domain.TrendingSingle
import kotlinx.coroutines.*


class TitlesFragment : Fragment(), RankingAdapter.onItemClickListener {
    private lateinit var myAdapter: RankingAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    var res: List<TrendingSingle>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_titles, container, false)
        updateView()
        return view
    }
    private fun updateView(){
            GlobalScope.launch(Dispatchers.Default) {
                 res = getRankingTracksList("us", "itunes", "singles").trending

                withContext(Dispatchers.Main){
                    val recycle = view?.findViewById<RecyclerView>(R.id.ranking_track_recycler_view)
                    linearLayoutManager = LinearLayoutManager(context)
                    myAdapter = RankingAdapter(requireContext(), res!!, this@TitlesFragment)
                    myAdapter.notifyDataSetChanged()
                    recycle!!.adapter = myAdapter
                    recycle!!.layoutManager = linearLayoutManager
                }
            }
    }

    override fun onItemClick(position: Int) {


        GlobalScope.launch(Dispatchers.Default) {
            val result = getArtistById(res?.get(position)?.idArtist.toString()).artists.last()

            withContext(Dispatchers.Main){
                val intent = Intent(context, ArtistDetailActivity::class.java)
                val bundle = Bundle()
                bundle.putParcelable("res", result)
                intent.putExtra("myBundle", bundle)
                startActivity(intent)
            }
        }

    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TitlesFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}

