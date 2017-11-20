package com.lethalskillzz.nomoreqs.presentation.auth.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewCompat
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnTouch
import com.lethalskillzz.nomoreqs.R
import com.lethalskillzz.nomoreqs.presentation.base.BaseFragment
import com.lethalskillzz.nomoreqs.presentation.custom.flip.BounceOvershootInterpolator
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent
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

    @BindView(R.id.focus_hider)
    lateinit var logo: View

    @BindView(R.id.button_login)
    lateinit var loginButton: View

    @BindView(R.id.email_input_layout)
    lateinit var emailInputLayout: View

    @BindView(R.id.email_input)
    lateinit var emailInput: View

    @BindView(R.id.password_input_layout)
    lateinit var passwordInputLayout: View

    @BindView(R.id.password_input)
    lateinit var passwordInput: View


    fun newInstance(): LoginFragment {
        val args = Bundle()

        val fragment = LoginFragment()
        fragment.setArguments(args)
        return fragment
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        KeyboardVisibilityEvent.setEventListener(activity) { isOpen ->
            val scale = if (isOpen) 0.75f else 1f
            ViewCompat.animate(logo)
                    .scaleX(scale)
                    .scaleY(scale)
                    .setDuration(300)
                    .start()
            if (!isOpen) cleaFocus()
        }
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

        controller!!.text = mergeColoredText(getString(R.string.or), getString(R.string.sign_up_or_label),
                ContextCompat.getColor(context, R.color.white_trans),
                ContextCompat.getColor(context, R.color.color_text))
    }


    override fun cleaFocus() {
        //views!!.forEach { view -> view.clearFocus() }
    }

    override fun fireAnimation() {


        val buttonAnimator = ObjectAnimator.ofFloat(controller, View.TRANSLATION_X, controller!!.translationX)

        controller!!.translationX = controller!!.width.toFloat()

        buttonAnimator.interpolator = BounceOvershootInterpolator(4f)
        val buttonSet = AnimatorSet()
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


//    @OnClick(R.id.controller)
//    fun makeTransition() {
//        if (callback != null) {
//            callback!!.remove(this)
//        }
//    }



    var x1 = 0f
    var x2 = 0f
    var MIN_DISTANCE = 150

    @OnTouch(R.id.controller)
    fun buttonsTouched(v: View, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.e("controller", "down")
                x1 = event.x
                if (callback != null) {
                    callback!!.remove(this)
                }
            }
            MotionEvent.ACTION_UP -> {
                Log.e("controller", "up")
                x2 = event.x
                var deltaX: Float = x2 - x1;

                if (Math.abs(deltaX) > MIN_DISTANCE) {
                    // Left to Right swipe action
                    if (x2 > x1) {
                        if (callback != null) {
                            callback!!.remove(this)
                        }
                    }
                    // Right to left swipe action
                    else {
                        if (callback != null) {
                            callback!!.remove(this)
                        }
                    }
                } else {
                    // consider as something else - a screen tap for example

                }
            }
            MotionEvent.ACTION_MOVE -> {
                Log.e("controller", "move")
            }
            else -> {
                Log.e("controller", "else")
            }

        }

        return false
    }

}

