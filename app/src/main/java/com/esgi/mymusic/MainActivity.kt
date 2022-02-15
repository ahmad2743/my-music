package com.esgi.mymusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.esgi.mymusic.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var myToolbar: Toolbar
    val rankingFragment = RankingFragment()
    val searchFragment = SearchFragment()
    val favoriteFragment = FavoriteFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupTab()

        myToolbar = findViewById(R.id.toolbar_add)
        myToolbar.title = resources.getString(R.string.classements_home_icon_value)
        setSupportActionBar(myToolbar)

        val navButt = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        navButt?.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.raking_home_icon -> {
                    myToolbar.title = resources.getString(R.string.classements_home_icon_value)
                    replaceFragment(rankingFragment)}
                R.id.search_home_icon -> {
                    myToolbar.title = resources.getString(R.string.recherche_home_icon_value)
                    replaceFragment(searchFragment)
                }
                R.id.fav_home_icon -> {
                    myToolbar.title = resources.getString(R.string.favoris_home_icon_value)
                    replaceFragment(favoriteFragment)}
            }
            return@setOnNavigationItemSelectedListener true
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, fragment)
            commit()
        }
    }

    fun setupTab(){
        val viewPager = findViewById<ViewPager>(R.id.my_view_pager)
        val tabLayout = findViewById<TabLayout>(R.id.my_tab_layout)

        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(TitlesFragment(), "Titres")
        fragmentAdapter.addFragment(AlbumFragment(), "Albums")
        viewPager.adapter = fragmentAdapter
        tabLayout?.setupWithViewPager(viewPager)
    }
}