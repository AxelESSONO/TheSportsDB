package com.axel.thesportsdb.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.axel.thesportsdb.R
import com.bumptech.glide.Glide

@BindingAdapter("android:load")
fun setImageViewResource(imageView: ImageView, resource: String) {
    Glide.with(imageView.context)
        .load(resource)
        .placeholder(R.drawable.ic_place_holder)
        .into(imageView)
}