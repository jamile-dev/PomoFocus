package io.github.jamilelima.pomofocus.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import io.github.jamilelima.pomofocus.fragments.TasksDoneFragment
import io.github.jamilelima.pomofocus.fragments.TasksPendingFragment

class TabsAssessorAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(i: Int): Fragment? {
        return when (i) {
            0 -> {
                TasksPendingFragment()
            }
            1 -> {
                TasksDoneFragment()
            }
            else -> null
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Pending"

            1 -> "Done"

            else -> null
        }
    }
}
