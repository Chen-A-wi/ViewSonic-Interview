package com.example.spacex.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.spacex.common.ext.loadFromUrl

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("src")
    fun setImageFromUrl(imageView: ImageView, url: String) {
        imageView.loadFromUrl(url)
    }
}