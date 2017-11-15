package com.lethalskillzz.nomoreqs.presentation.base

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.view.View
import butterknife.Unbinder
import com.lethalskillzz.nomoreqs.di.component.ActivityComponent
import io.armcha.ribble.presentation.base_mvp.base.BaseActivity

/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */

/**
 * Created by ibrahimabdulkadir on 04/08/2017.
 */

abstract class BaseFragment: Fragment(), MvpView {

    var baseActivity:BaseActivity? = null
        private set
    private var mUnBinder:Unbinder? = null
    private val mProgressDialog: ProgressDialog? = null

    override val isNetworkConnected:Boolean
        get() = if (baseActivity != null) {
            baseActivity!!.isNetworkConnected
        } else false


    val activityComponent: ActivityComponent?
        get() {
            return if (baseActivity != null) {
                baseActivity!!.activityComponent
            } else null
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(view)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity)
        {
            val activity = context as BaseActivity?
            this.baseActivity = activity
            activity!!.onFragmentAttached()
        }
    }

    override fun showLoading() {
        hideLoading()
    }

    override fun hideLoading() {

    }

    override fun onError(message:String) {
        if (baseActivity != null)
        {
            baseActivity!!.onError(message)
        }
    }

    override fun onError(@StringRes resId:Int) {
        if (baseActivity != null)
        {
            baseActivity!!.onError(resId)
        }
    }

    override fun showMessage(message:String) {
        if (baseActivity != null)
        {
            baseActivity!!.showMessage(message)
        }
    }

    override fun showMessage(@StringRes resId:Int) {
        if (baseActivity != null)
        {
            baseActivity!!.showMessage(resId)
        }
    }

    override fun onDetach() {
        baseActivity = null
        super.onDetach()
    }

    fun setUnBinder(unBinder: Unbinder) {
        mUnBinder = unBinder
    }

    protected abstract fun setUp(view: View?)

    override fun onDestroy() {
        if (mUnBinder != null)
        {
            mUnBinder!!.unbind()
        }
        super.onDestroy()
    }

    interface Callback {

        fun onFragmentAttached()

        fun onFragmentDetached(tag:String)
    }
}