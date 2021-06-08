package app.gresgo.heode.main.profile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.Insets
import app.gresgo.heode.base.ui.BaseFragment
import app.gresgo.heode.databinding.ProfileBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment: BaseFragment<ProfileBinding>() {

    private val viewModel: ProfileViewModel by viewModel()

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = ProfileBinding.inflate(inflater, container, false)

    override fun onInsetsChanged(view: View?, insets: Insets) {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }

}