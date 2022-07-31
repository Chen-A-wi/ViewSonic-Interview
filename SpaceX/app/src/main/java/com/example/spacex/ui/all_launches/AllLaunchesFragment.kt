package com.example.spacex.ui.all_launches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.spacex.R
import com.example.spacex.databinding.FragmentAllLaunchesBinding
import com.example.spacex.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AllLaunchesFragment : BaseFragment() {
    private lateinit var binding: FragmentAllLaunchesBinding
    private val vm by viewModel<AllLaunchesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllLaunchesBinding.inflate(inflater, container, false).apply {
            vm = this@AllLaunchesFragment.vm
            lifecycleOwner = this@AllLaunchesFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initToolbar(
            appbarBinding = binding.appbar,
            appbarTitleResId = R.string.all_launches,
            isShowLeftButton = false,
        )
        observeLiveData()
    }

    private fun observeLiveData() {
        vm.apply {
            clickLiveEvent.observe(viewLifecycleOwner) { id ->
                when (id) {
                    R.id.button -> {
                        findNavController().navigate(R.id.action_allLaunchesFragment_to_launchDetailFragment)
                    }
                }
            }
        }
    }
}