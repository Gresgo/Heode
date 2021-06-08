package app.gresgo.heode.main.team.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.Insets
import app.gresgo.heode.base.ui.BaseFragment
import app.gresgo.heode.databinding.TeamUsersBinding

class TeamUsersFragment: BaseFragment<TeamUsersBinding>() {

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = TeamUsersBinding.inflate(inflater, container, false)

    override fun onInsetsChanged(view: View?, insets: Insets) {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.usersRecycler.adapter
    }

}