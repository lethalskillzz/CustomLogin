package com.lethalskillzz.nomoreqs.presentation.auth.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.lethalskillzz.nomoreqs.R
import com.lethalskillzz.nomoreqs.presentation.base.BaseFragment
import com.lethalskillzz.nomoreqs.presentation.custom.BounceOvershootInterpolator
import javax.inject.Inject

/**
 * Created by ibrahimabdulkadir on 16/11/2017.
 */

class LoginFragment : BaseFragment(), LoginMvpView {

    @Inject lateinit var mPresenter: LoginMvpPresenter<LoginMvpView>

//    @BindBool(R.bool.master_detail_mode)
//     var masterDetailMode: Boolean = false


//    @BindViews(value = *intArrayOf(R.id.email_input_edit, R.id.password_input_edit))
//    lateinit var views: List<View>

    @BindView(R.id.controller)
    lateinit var controller: TextView

    @BindView(R.id.parent)
    lateinit var parent: ViewGroup

    @BindView(R.id.first)
    lateinit var first: View

    @BindView(R.id.second)
    lateinit var second: View

    @BindView(R.id.last)
    lateinit var last: View


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

        controller!!.text = mergeColoredText(getString(R.string.or), getString(R.string.log_in_or_label),
                ContextCompat.getColor(context, R.color.white_trans),
                ContextCompat.getColor(context, R.color.color_text))
    }


    override fun cleaFocus() {
        //views!!.forEach { view -> view.clearFocus() }
    }

    override fun fireAnimation() {
        val offsetX = parent!!.getWidth() - (last!!.getX() + last!!.getWidth()) - resources.getDimension(R.dimen.option_size)

        val firstAnimator = ObjectAnimator.ofFloat (first, View.TRANSLATION_X, 0f)
        val secondAnimator = ObjectAnimator.ofFloat(second, View.TRANSLATION_X, 0f)
        val lastAnimator = ObjectAnimator.ofFloat(last, View.TRANSLATION_X, 0f)

        val buttonAnimator = ObjectAnimator.ofFloat(controller, View.TRANSLATION_X, controller!!.translationX)
        first!!.translationX = offsetX
        second!!.translationX = offsetX
        last!!.translationX = offsetX
        controller!!.translationX = controller!!.width.toFloat()

        buttonAnimator.interpolator = BounceOvershootInterpolator(4f)
        val buttonSet = AnimatorSet()
        buttonSet.playTogether(firstAnimator, secondAnimator, lastAnimator)
        buttonSet.interpolator = BounceOvershootInterpolator(2f)
        val animatorSet = AnimatorSet()
        animatorSet.startDelay = 500
        animatorSet.playTogether(buttonSet, buttonAnimator)
        animatorSet.start()
    }

    fun mergeColoredText(leftPart: String, rightPart: String, leftColor: Int, rightColor: Int): SpannableStringBuilder {
        val builder = SpannableStringBuilder()
        val leftPartSpannable = SpannableString(leftPart.toUpperCase())
        val rightPartSpannable = SpannableString(rightPart.toUpperCase())
        leftPartSpannable.setSpan(ForegroundColorSpan(leftColor), 0, leftPart.length, 0)
        rightPartSpannable.setSpan(ForegroundColorSpan(rightColor), 0, rightPart.length, 0)
        return builder.append(leftPartSpannable).append("  ").append(rightPartSpannable)
    }


    @OnClick(R.id.controller)
    fun makeTransition() {
        if (callback != null) {
            callback!!.remove(this)
        }
    }

}

