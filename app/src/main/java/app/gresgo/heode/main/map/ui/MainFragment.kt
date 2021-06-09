package app.gresgo.heode.main.map.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.Insets
import androidx.core.view.updatePadding
import androidx.navigation.fragment.findNavController
import app.gresgo.heode.R
import app.gresgo.heode.base.ui.BaseFragment
import app.gresgo.heode.databinding.ControlsBinding

class MainFragment: BaseFragment<ControlsBinding>() {

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = ControlsBinding.inflate(inflater, container, false)

    override fun onInsetsChanged(view: View?, insets: Insets) {
        binding.controls.updatePadding(top = insets.top)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.team.setOnClickListener {
            findNavController().navigate(R.id.team)
        }

        binding.profile.setOnClickListener {
            findNavController().navigate(R.id.profile)
        }

        binding.radar.setOnClickListener {
            findNavController().navigate(R.id.radar)
        }
    }

}