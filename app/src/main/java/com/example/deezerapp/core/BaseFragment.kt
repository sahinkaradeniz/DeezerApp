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
import com.example.common.extension.getParent
import com.example.common.extension.toastMessage
import java.util.*


typealias Inflater<T> = (LayoutInflater, ViewGroup?, Boolean) -> T
/**
 * BaseFragment is an abstract class that serves as the base for all fragments in the DeezerApp.
 * It provides common functionality and lifecycle methods for fragments.
 *
 * @param <VB> The type of ViewBinding used by the fragment.
 */
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


    /**
     * Callback method invoked when the fragment's view creation is finished.
     * Subclasses should override this method to perform additional setup and initialization.
     */
    abstract fun onCreateFinished()

    /**
     * Initializes the listeners for UI interactions.
     * Subclasses should override this method to set up event listeners.
     */
    open fun initListener() {}

    /**
     * Shows the progress indicator.
     * This method is used to display a loading indicator while an operation is in progress.
     */
    fun showProgress() {
        progressStack.add(Unit)
        parent?.showProgress()
    }

    /**
     * Hides the progress indicator.
     * This method is used to hide the loading indicator when an operation is complete.
     */
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

    fun errorMessage(
        error: String
    ) {
       requireContext().toastMessage(error)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        hideProgressImmediately()
    }

}