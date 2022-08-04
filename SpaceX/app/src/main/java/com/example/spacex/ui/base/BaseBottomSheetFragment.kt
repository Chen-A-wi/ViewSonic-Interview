package com.example.spacex.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.example.spacex.common.ext.getBinding
import com.example.spacex.ui.MainActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseBottomSheetFragment<T : ViewDataBinding> : BottomSheetDialogFragment() {
    private var _binding: T? = null
    val binding: T? get() = _binding
    var act: MainActivity? = null
    lateinit var ctx: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (activity is MainActivity) {
            act = activity as MainActivity
        }
        ctx = requireContext()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getBinding(inflater, container)
        _binding?.lifecycleOwner = viewLifecycleOwner
        return binding?.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
