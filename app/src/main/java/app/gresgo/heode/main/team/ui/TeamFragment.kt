package app.gresgo.heode.main.team.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.Insets
import androidx.core.view.updatePadding
import androidx.recyclerview.widget.RecyclerView
import app.gresgo.heode.base.ui.BaseFragment
import app.gresgo.heode.base.ui.PagerAdapter
import app.gresgo.heode.databinding.TeamBinding
import com.google.android.material.tabs.TabLayoutMediator

class TeamFragment: BaseFragment<TeamBinding>() {

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = TeamBinding.inflate(inflater, container, false)

    override fun onInsetsChanged(view: View?, insets: Insets) {
        binding.teamTabs.updatePadding(top = insets.top)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.teamPages.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        binding.teamPages.adapter = PagerAdapter(
            this,
            listOf(TeamUsersFragment(), TeamRequestsFragment())
        )
        val tabs = arrayOf("Users", "Requests")
        TabLayoutMediator(binding.teamTabs, binding.teamPages) { tab, i ->
            tab.text = tabs[i]
        }.attach()
    }

}