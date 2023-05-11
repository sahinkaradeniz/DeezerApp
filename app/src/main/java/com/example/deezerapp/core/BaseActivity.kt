package com.example.deezerapp.core

import android.view.WindowManager
import androidx.fragment.app.FragmentActivity
import com.example.common.DeezerProgress

abstract class BaseActivity : FragmentActivity() {

    private val progress: DeezerProgress by lazy {
        DeezerProgress()
    }

    fun showProgress() {
        if (!progress.isAdded) {
            progress.show(supportFragmentManager, "DeezerProgressDialog")
            window?.setFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            )
        }
    }

    fun hideProgress() {
        progress.dismiss()
        window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

}