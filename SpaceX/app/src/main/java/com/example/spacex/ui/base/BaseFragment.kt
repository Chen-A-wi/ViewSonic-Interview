package com.example.spacex.ui.base

import android.content.Context
import android.view.View
import androidx.annotation.StringRes
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.spacex.R
import com.example.spacex.databinding.IncludeAppBarBinding
import com.example.spacex.ui.MainActivity

abstract class BaseFragment : Fragment() {
    lateinit var act: MainActivity
    lateinit var ctx: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        act = activity as MainActivity
        ctx = requireContext()
    }

    fun initToolbar(
        appbarBinding: IncludeAppBarBinding,
        @StringRes appbarTitleResId: Int = R.string.empty,
        isShowLeftButton: Boolean = false,
    ) {

        fun setupButton(imageButton: View, isShowButton: Boolean) {
            if (isShowButton) {
                imageButton.isVisible = true
                imageButton.setOnClickListener {
                    act.onBackPressed()
                }
            } else {
                imageButton.isGone = true
            }
        }

        appbarBinding.run {
            act.setSupportActionBar(toolbar)
            tvTitle.text = getString(appbarTitleResId)
            setupButton(imgLeft, isShowLeftButton)
        }
    }
}