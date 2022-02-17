package com.esgi.mymusic.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.esgi.mymusic.MainActivity
import com.esgi.mymusic.R
import com.esgi.mymusic.RankingAdapter
import com.esgi.mymusic.data.MusicApiManager.Companion.getRankingTracksList
import com.esgi.mymusic.domain.CurrentTrendingSingles
import com.esgi.mymusic.domain.TrendingSingle
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class TitlesFragment : Fragment() {
    private lateinit var myAdapter: RankingAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

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
                 val res = getRankingTracksList("us", "itunes", "singles").trending.map { elt -> elt }

                withContext(Dispatchers.Main){
                    val recycle = view?.findViewById<RecyclerView>(R.id.ranking_track_recycler_view)
                    linearLayoutManager = LinearLayoutManager(context)
                    myAdapter = RankingAdapter(requireContext(), res)
                    myAdapter.notifyDataSetChanged()
                    recycle!!.layoutManager = linearLayoutManager
                    recycle.adapter = myAdapter
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