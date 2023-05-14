package com.example.common.extension

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.provider.Settings
import android.widget.Toast

/**
 * Checks if the device has an active internet connection.
 *
 * @return true if the device has an active internet connection, false otherwise.
 */
fun Context.isNetworkAvailable(): Boolean {
    val connectivityManager =
        getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkCapabilities = connectivityManager.activeNetwork ?: return false
    val capabilities =
        connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false

    return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
}

fun Context.toastMessage(message:String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}

/**
 * Opens the device's internet settings with a confirmation dialog.
 * Displays an AlertDialog with a message asking the user if they want to open the internet settings.
 * If the user selects "Yes", it opens the internet settings screen.
 * If the user selects "No", no action is taken.
 */
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