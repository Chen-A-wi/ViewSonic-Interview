package com.example.spacex.ui.all_launches.bottom_sheet_dialog

import android.os.Bundle
import android.view.View
import com.example.spacex.R
import com.example.spacex.common.SortType
import com.example.spacex.databinding.BottomSheetDialogSortBinding
import com.example.spacex.ui.base.BaseBottomSheetFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SortBottomSheetDialog(
    private val sortType: SortType,
    private val radioClickEvent: ((sortType: SortType) -> Unit)
) : BaseBottomSheetFragment<BottomSheetDialogSortBinding>() {
    private val viewModel by viewModel<SortBottomSheetDialogViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.vm = viewModel
        viewModel.initData(sortType = sortType)
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.apply {
            clickLiveEvent.observe(viewLifecycleOwner) { id ->
                when (id) {
                    R.id.rbtnSort -> radioClickEvent.invoke(SortType.SORT)
                    R.id.rbtnReversed -> radioClickEvent.invoke(SortType.REVERSED)
                }
            }
        }
    }
}