package app.gresgo.heode.main.team.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.Insets
import app.gresgo.heode.base.ui.BaseFragment
import app.gresgo.heode.databinding.TeamRequestsBinding

class TeamRequestsFragment: BaseFragment<TeamRequestsBinding>() {

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = TeamRequestsBinding.inflate(inflater, container, false)

    override fun onInsetsChanged(view: View?, insets: Insets) {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}