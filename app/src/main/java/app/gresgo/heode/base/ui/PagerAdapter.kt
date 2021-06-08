package app.gresgo.heode.base.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter: FragmentStateAdapter {

    constructor(fragment: Fragment, fragments: List<Fragment>): super(fragment) {
        this.fragments = fragments
    }
    constructor(activity: FragmentActivity, fragments: List<Fragment>): super(activity) {
        this.fragments = fragments
    }

    private val fragments: List<Fragment>

    override fun createFragment(position: Int): Fragment =
        fragments[position]

    override fun getItemCount(): Int = fragments.size
}