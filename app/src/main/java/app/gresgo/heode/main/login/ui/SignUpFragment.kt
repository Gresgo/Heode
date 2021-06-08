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
import app.gresgo.heode.databinding.LoginSignUpBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SignUpFragment: BaseFragment<LoginSignUpBinding>() {

    private val viewModel: LoginViewModel by sharedViewModel()

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = LoginSignUpBinding.inflate(inflater, container, false)

    override fun onInsetsChanged(view: View?, insets: Insets) {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toSignIn.setOnClickListener {
            val options = NavOptions.Builder()
                .setPopUpTo(R.id.signUpFragment, true)
                .build()
            findNavController().navigate(R.id.signInFragment, null, options)
        }

        binding.signUp.setOnClickListener {
            viewModel.signUp(
                name = binding.name.text.toString(),
                email = binding.email.text.toString(),
                password = binding.password.text.toString()
            )
        }
    }

}