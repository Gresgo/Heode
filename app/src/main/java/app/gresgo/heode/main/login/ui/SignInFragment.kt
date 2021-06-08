package app.gresgo.heode.main.login.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.Insets
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import app.gresgo.heode.R
import app.gresgo.heode.base.ui.BaseFragment
import app.gresgo.heode.databinding.LoginSignInBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SignInFragment: BaseFragment<LoginSignInBinding>() {

    private val viewModel: LoginViewModel by sharedViewModel()

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = LoginSignInBinding.inflate(inflater, container, false)

    override fun onInsetsChanged(view: View?, insets: Insets) {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toSignUp.setOnClickListener {
            val options = NavOptions.Builder()
                .setPopUpTo(R.id.signInFragment, true)
                .build()
            findNavController().navigate(R.id.signUpFragment, null, options)
        }

        binding.signIn.setOnClickListener {
            viewModel.signIn(
                email = binding.email.text.toString(),
                password = binding.password.text.toString()
            )
        }
    }

}