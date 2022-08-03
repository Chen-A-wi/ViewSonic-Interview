package com.example.spacex.ui.launch_detail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.example.spacex.R
import com.example.spacex.databinding.FragmentLaunchDetailBinding
import com.example.spacex.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class LaunchDetailFragment : BaseFragment<FragmentLaunchDetailBinding>() {
    private val args: LaunchDetailFragmentArgs by navArgs()
    private val viewModel by viewModel<LaunchDetailViewModel> { parametersOf(args.argRocketDataItem) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.vm = viewModel
        initViews()
    }

    private fun initViews() {
        binding?.apply {
            initToolbar(
                appbarBinding = appbar,
                appbarTitleResId = R.string.launch_detail,
                isShowLeftButton = true,
            )
        }
    }
}