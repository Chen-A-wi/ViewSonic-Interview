package com.example.spacex.ui.base

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.afollestad.materialdialogs.MaterialDialog
import com.example.spacex.R
import com.example.spacex.common.ext.getBinding
import com.example.spacex.data.ErrorMessage
import com.example.spacex.databinding.IncludeAppBarBinding
import com.example.spacex.ui.MainActivity

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {
    private var _binding: T? = null
    val binding: T? get() = _binding
    var act: MainActivity? = null
    lateinit var ctx: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        act = activity as MainActivity
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

    fun initToolbar(
        appbarBinding: IncludeAppBarBinding,
        @StringRes appbarTitleResId: Int = R.string.empty,
        isShowLeftButton: Boolean = false,
    ) {
        fun setupButton(imageButton: View, isShowButton: Boolean) {
            if (isShowButton) {
                imageButton.isVisible = true
                imageButton.setOnClickListener {
                    act?.onBackPressed()
                }
            } else {
                imageButton.isGone = true
            }
        }

        appbarBinding.run {
            act?.setSupportActionBar(toolbar)
            tvTitle.text = getString(appbarTitleResId)
            setupButton(imgLeft, isShowLeftButton)
        }
    }

    //region API Error Dialog
    fun observeErrorEvent(errorEvent: MutableLiveData<ErrorMessage>) {
        errorEvent.observe(viewLifecycleOwner) {
            it?.let {
                showErrorDialog(it)
            }
        }
    }

    private fun showErrorDialog(errorMessage: ErrorMessage) {
        MaterialDialog(ctx).show {
            title(res = R.string.alert_api_error)
            cancelable(false)
            message(text = errorMessage.message(ctx))
        }.positiveButton(res = R.string.btn_confirm)
    }
    //endregion

    fun checkInternet(): Boolean {
        val connectivityManager =
            ctx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    Log.i("[Internet]", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    Log.i("[Internet]", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                    Log.i("[Internet]", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
        }
        return false
    }
}