package com.example.booktracker.menu

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.booktracker.done.DoneListFragment
import com.example.booktracker.reading.ReadingListFragment
import com.example.booktracker.toread.ToReadFragment

class MenuViewPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    private val bookListFragments: Array<Fragment> = arrayOf<Fragment>(
        DoneListFragment(),
        ReadingListFragment(),
        ToReadFragment()
    )

    val bookListNames = arrayOf(
        "Finished",
        "In Progress",
        "For Later"
    )

    override fun getItemCount(): Int {
        return bookListNames.size
    }

    override fun createFragment(position: Int): Fragment {
        return bookListFragments[position]
    }
}