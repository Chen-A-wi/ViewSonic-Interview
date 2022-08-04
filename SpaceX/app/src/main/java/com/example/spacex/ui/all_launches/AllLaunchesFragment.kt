package com.example.spacex.ui.all_launches

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.afollestad.materialdialogs.MaterialDialog
import com.example.spacex.R
import com.example.spacex.databinding.FragmentAllLaunchesBinding
import com.example.spacex.ui.all_launches.bottom_sheet_dialog.SortBottomSheetDialog
import com.example.spacex.ui.all_launches.launches_list.LaunchesListAdapter
import com.example.spacex.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.system.exitProcess

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

            rcvLaunchesList.adapter = LaunchesListAdapter(
                rocketList = viewModel.lunchesList
            ) { itemData ->
                findNavController().navigate(
                    AllLaunchesFragmentDirections.actionAllLaunchesFragmentToLaunchDetailFragment(
                        argRocketDataItem = itemData
                    )
                )
            }
        }
    }

    private fun observeLiveData() {
        viewModel.apply {
            clickLiveEvent.observe(viewLifecycleOwner) { id ->
                when (id) {
                    R.id.tvSort -> {
                        val bottomSheetFragment = SortBottomSheetDialog(
                            sortTypeFlow.value
                        ) { sortType ->
                            sortTypeText.value = sortType.resString
                            sortTypeFlow.value = sortType
                        }
                        bottomSheetFragment.show(
                            this@AllLaunchesFragment.childFragmentManager,
                            bottomSheetFragment.tag
                        )
                    }
                }
            }

            notifyEvent.observe(viewLifecycleOwner) {
                binding?.rcvLaunchesList?.adapter?.notifyDataSetChanged()
            }

            observeErrorEvent(errorEvent)
        }
    }

    //region Internet
    override fun onResume() {
        super.onResume()
        if (!checkInternet()) {
            showPleaseInternetDialog()
        }
    }

    private fun showPleaseInternetDialog() {
        MaterialDialog(ctx).show {
            cancelable(true)
            message(text = context.getString(R.string.alert_check_internet_msg))
        }.positiveButton(res = R.string.btn_confirm) {
            if (!checkInternet()) {
                closeApp()
            }
            viewModel.apply { getRocketLaunches(sortType = sortTypeFlow.value) }
        }.negativeButton(res = R.string.btn_cancel) {
            closeApp()
        }
    }

    private fun closeApp() {
        act?.finish()
        exitProcess(0)
    }
    //endregion
}