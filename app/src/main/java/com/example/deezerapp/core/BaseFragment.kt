package com.example.deezerapp.core

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding
import com.example.common.ResponseResult
import com.example.common.extension.getParent
import java.util.*


typealias Inflater<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding> protected constructor(
    private val inflater: Inflater<VB>
) : Fragment() {

    private var parent: BaseActivity? = null
    private val progressStack = Stack<Unit>()
    private var _binding: VB? = null
    val binding: VB get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflater(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parent = getParent<BaseActivity>()
        onCreateFinished()
        initListener()
    }

    abstract fun onCreateFinished()
    open fun initListener() {}

    fun showProgress() {
        progressStack.add(Unit)
        parent?.showProgress()
    }

    fun hideProgress() {
        if (progressStack.size > 0)
            progressStack.pop()
        if (progressStack.size == 0)
            parent?.hideProgress()
    }

    private fun hideProgressImmediately() {
        progressStack.clear()
        getFragmentManagerSafely()?.let {
            val progress = it.findFragmentByTag("DeezerProgressDialog")
            if (progress != null && progress is DialogFragment) {
                progress.dismissAllowingStateLoss()
            }
        }
    }
    private fun getFragmentManagerSafely(): FragmentManager? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            parentFragmentManager
        } else {
            fragmentManager
        }
    }

    fun <T> handleError(
        error: ResponseResult.Error<T>
    ) {
        // TODO("Error Dialog")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        hideProgressImmediately()
    }

}