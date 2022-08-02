package com.example.spacex.ui.all_launches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.spacex.R
import com.example.spacex.common.SortType
import com.example.spacex.databinding.FragmentAllLaunchesBinding
import com.example.spacex.ui.all_launches.bottom_sheet_dialog.SortBottomSheetDialog
import com.example.spacex.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AllLaunchesFragment : BaseFragment<FragmentAllLaunchesBinding>() {
    private val viewModel by viewModel<AllLaunchesViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.vm = viewModel
        initViews()
        observeLiveData()
    }

    private fun initViews() {
        binding?.apply {
            initToolbar(
                appbarBinding = appbar,
                appbarTitleResId = R.string.all_launches,
                isShowLeftButton = false,
            )
        }
    }

    private fun observeLiveData() {
        viewModel.apply {
            clickLiveEvent.observe(viewLifecycleOwner) { id ->
                when (id) {
                    R.id.button -> {
                        findNavController().navigate(R.id.ActionAllLaunchesFragmentToLaunchDetailFragment)
                    }
                    R.id.tvSort -> {
                        val bottomSheetFragment = SortBottomSheetDialog(
                            sortType.value ?: SortType.SORT
                        ) { sortType ->
                            viewModel.sortType.value = sortType
                            sortTypeText.value = sortType.resString
                        }
                        bottomSheetFragment.show(
                            this@AllLaunchesFragment.childFragmentManager,
                            bottomSheetFragment.tag
                        )
                    }
                }
            }

            observeErrorEvent(errorEvent)
        }
    }
}