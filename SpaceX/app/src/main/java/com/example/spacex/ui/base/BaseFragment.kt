package com.example.spacex.ui.base

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import android.view.View
import androidx.annotation.StringRes
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.afollestad.materialdialogs.MaterialDialog
import com.example.spacex.R
import com.example.spacex.databinding.IncludeAppBarBinding
import com.example.spacex.ui.MainActivity
import kotlin.system.exitProcess

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

    override fun onResume() {
        super.onResume()
        if (!checkInternet()) {
            showPleaseInternetDialog()
        }
    }

    private fun checkInternet(): Boolean {
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

    private fun showPleaseInternetDialog() {
        MaterialDialog(ctx).show {
            cancelable(true)
            message(text = context.getString(R.string.alert_check_internet_msg))
        }.positiveButton(res = R.string.btn_confirm) {
            if (!checkInternet()) {
                closeApp()
            }
        }.negativeButton(res = R.string.btn_cancel) {
            closeApp()
        }
    }

    private fun closeApp() {
        act.finish()
        exitProcess(0)
    }
}