package app.gresgo.heode.main.login.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.Insets
import androidx.core.view.updatePadding
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import app.gresgo.heode.R
import app.gresgo.heode.base.ui.BaseFragment
import app.gresgo.heode.databinding.LoginBinding
import app.gresgo.heode.main.MainActivity
import app.gresgo.heode.utils.PreferenceKeys
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import timber.log.Timber

class LoginFragment: BaseFragment<LoginBinding>() {

    private val viewModel: LoginViewModel by sharedViewModel()
    private val preferences: SharedPreferences by inject()

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = LoginBinding.inflate(inflater, container, false)

    override fun onInsetsChanged(view: View?, insets: Insets) {
        binding.loginHost.updatePadding(bottom = insets.bottom)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHostFragment = childFragmentManager.findFragmentById(R.id.login_host) as NavHostFragment
        val controller = navHostFragment.navController
        val graph = controller.navInflater.inflate(R.navigation.login)
        controller.graph = graph

        lifecycleScope.launchWhenStarted {
            viewModel.token.value = null
            viewModel.token.collect {
                it ?: return@collect
                preferences.edit()
                    .putString(PreferenceKeys.TOKEN, it)
                    .apply()
                val options = NavOptions.Builder()
                    .setPopUpTo(R.id.login, true)
                    .build()
                (requireActivity() as MainActivity).createMap()
                findNavController().navigate(R.id.controls, null, options)
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.onError.value = null
            viewModel.onError.collect {
                it ?: return@collect
                withContext(Dispatchers.Main) {
                    Snackbar.make(requireView(), it, Snackbar.LENGTH_SHORT).show()
                    viewModel.onError.value = null
                }
            }
        }
    }

}