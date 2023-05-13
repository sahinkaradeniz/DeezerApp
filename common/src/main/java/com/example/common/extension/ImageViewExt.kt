package com.example.common.extension

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
/**
 * Loads an image from the given URL into the ImageView using Glide library.
 *
 * @param url the URL of the image to be loaded
 */
fun ImageView.downloadFromUrl(url: String?){
    val options = RequestOptions()
        .placeholder( placeholderProgressBar(this.context))
    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}
/**
 * Creates and returns a CircularProgressDrawable as a placeholder for image loading.
 *
 * @param context the context to create the CircularProgressDrawable
 * @return the created CircularProgressDrawable
 */
fun placeholderProgressBar(context: Context) : CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}