package com.example.spacex.ui.launch_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spacex.R
import com.example.spacex.databinding.FragmentLaunchDetailBinding
import com.example.spacex.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LaunchDetailFragment : BaseFragment() {
    private lateinit var binding: FragmentLaunchDetailBinding
    private val vm by viewModel<LaunchDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLaunchDetailBinding.inflate(inflater, container, false).apply {
            vm = this@LaunchDetailFragment.vm
            lifecycleOwner = this@LaunchDetailFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initToolbar(
            appbarBinding = binding.appbar,
            appbarTitleResId = R.string.launch_detail,
            isShowLeftButton = true,
        )
    }
}