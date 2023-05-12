package com.example.common.extension

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.provider.Settings

fun Context.isNetworkAvailable(): Boolean {
    val connectivityManager =
        getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkCapabilities = connectivityManager.activeNetwork ?: return false
    val capabilities =
        connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false

    return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
}

fun Context.navigateToInternetSettingsWithConfirmation() {
    val builder = AlertDialog.Builder(this)
    builder.setTitle("Internet Settings")
    builder.setMessage("Do you want to open Internet settings?")
    builder.setPositiveButton("Yes") { _, _ ->
        val intent = Intent(Settings.ACTION_WIFI_SETTINGS)
        startActivity(intent)
    }
    builder.setNegativeButton("No", null)
    builder.create().show()
}