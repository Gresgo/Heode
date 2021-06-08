package app.gresgo.heode.main.radar.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.Insets
import app.gresgo.heode.base.ui.BaseFragment
import app.gresgo.heode.databinding.RadarBinding

class RadarFragment: BaseFragment<RadarBinding>() {

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = RadarBinding.inflate(inflater, container, false)

    override fun onInsetsChanged(view: View?, insets: Insets) {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}