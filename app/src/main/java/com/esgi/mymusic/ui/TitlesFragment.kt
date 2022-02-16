package com.esgi.mymusic.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.esgi.mymusic.R
import com.esgi.mymusic.data.MusicApiManager.Companion.getRankingTracksLists
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher


class TitlesFragment : Fragment() {
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

        GlobalScope.launch(Dispatchers.Default) {
            val res = getRankingTracksLists("us", "itunes", "singles").trending


            withContext(Dispatchers.Main) {
                val result = res.map { tranck -> tranck.strTrack}
                view.findViewById<TextView>(R.id.test).text = result.joinToString { elt -> elt }
            }
        }


        return view
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