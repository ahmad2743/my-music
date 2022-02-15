package com.esgi.mymusic.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.esgi.mymusic.R
import com.google.android.material.tabs.TabLayout


class RankingFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ranking, container, false)

        var viewPagerMine = view.findViewById<ViewPager>(R.id.myViewPager)
        var tabLayout = view.findViewById<TabLayout>(R.id.myTabLayout)

        var fragmentAdapter = FragmentAdapter(childFragmentManager)
        fragmentAdapter.addFragment(TitlesFragment(), "Titres")
        fragmentAdapter.addFragment(AlbumFragment(), "Albums")
        viewPagerMine.adapter = fragmentAdapter
        tabLayout?.setupWithViewPager(viewPagerMine)

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RankingFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}