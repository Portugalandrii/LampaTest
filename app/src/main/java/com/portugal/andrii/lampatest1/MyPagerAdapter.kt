package com.portugal.andrii.lampatest1

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class MyPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return  when (position){
            0 -> FragmentStories()
            1 -> FragmentVideo()
            else -> FragmentFavourites()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> "STORIES"
            1 -> "VIDEO"
            else -> {
                return "FAVOURITES"
            }
        }
    }
}