package com.example.units_kotlin2

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.units_kotlin2.fragments.DistanceFragment
import com.example.units_kotlin2.fragments.SurfaceFragment
import com.example.units_kotlin2.fragments.VolumeFragment
import com.example.units_kotlin2.ui.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        sectionsPagerAdapter.addFragment(DistanceFragment(), "Distance")
        sectionsPagerAdapter.addFragment(SurfaceFragment(), "Surface")
        sectionsPagerAdapter.addFragment(VolumeFragment(), "Volume")

        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        //tabs.setTabMode(TabLayout.MODE_SCROLLABLE)
        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_all_inclusive_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_api_24)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_local_drink_24)
    }
}