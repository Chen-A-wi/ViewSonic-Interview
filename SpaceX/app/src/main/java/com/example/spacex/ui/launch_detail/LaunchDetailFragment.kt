package com.example.spacex.ui.launch_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spacex.R
import com.example.spacex.databinding.FragmentLaunchDetailBinding
import com.example.spacex.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LaunchDetailFragment : BaseFragment<FragmentLaunchDetailBinding>() {
    private val viewModel by viewModel<LaunchDetailViewModel>()

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