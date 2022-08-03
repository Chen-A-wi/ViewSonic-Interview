package com.example.spacex.common.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadFromUrl(url: String) =
    Glide.with(this.context.applicationContext)
        .load(url)
        .into(this)

fun ImageView.loadFromUrl(url: String, option: RequestOptions) =
    Glide.with(this.context.applicationContext)
        .load(url)
        .apply(option)
        .into(this)