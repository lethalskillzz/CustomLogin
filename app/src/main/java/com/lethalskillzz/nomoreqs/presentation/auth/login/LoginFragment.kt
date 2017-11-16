package com.lethalskillzz.nomoreqs.presentation.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindBool
import butterknife.ButterKnife
import com.lethalskillzz.nomoreqs.R
import com.lethalskillzz.nomoreqs.presentation.base.BaseFragment
import javax.inject.Inject

/**
 * Created by ibrahimabdulkadir on 16/11/2017.
 */

public class LoginFragment : BaseFragment(), LoginMvpView {

    @Inject lateinit var mPresenter: LoginMvpPresenter<LoginMvpView>

    @BindBool(R.bool.master_detail_mode)
    internal var masterDetailMode: Boolean = false


    fun newInstance(): LoginFragment {
        val args = Bundle()

        val fragment = LoginFragment()
        fragment.setArguments(args)
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val component = activityComponent
        if (component != null) {
            component!!.inject(this)
            setUnBinder(ButterKnife.bind(this, view))
            mPresenter!!.onAttach(this)

        }
        return view
    }

    override fun setUp(view: View?) {

    }


}

