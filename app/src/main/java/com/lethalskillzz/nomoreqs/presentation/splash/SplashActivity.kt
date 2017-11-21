package com.lethalskillzz.nomoreqs.presentation.splash

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.widget.AppCompatTextView
import android.view.View
import android.view.WindowManager
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import android.widget.RelativeLayout
import butterknife.BindView
import butterknife.ButterKnife
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.google.firebase.auth.FirebaseAuth
import com.lethalskillzz.nomoreqs.R
import com.lethalskillzz.nomoreqs.presentation.auth.AuthActivity
import com.lethalskillzz.nomoreqs.presentation.base.BaseActivity
import com.lethalskillzz.nomoreqs.presentation.base.BaseFragment
import com.lethalskillzz.nomoreqs.presentation.custom.splash.cnst.Flags
import com.lethalskillzz.nomoreqs.presentation.custom.splash.model.ConfigSplash
import com.lethalskillzz.nomoreqs.presentation.custom.splash.utils.UIUtil
import com.lethalskillzz.nomoreqs.presentation.main.MainActivity
import com.nineoldandroids.animation.Animator
import io.codetail.animation.SupportAnimator
import io.codetail.animation.ViewAnimationUtils
import javax.inject.Inject


/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */


class SplashActivity : BaseActivity(), SplashMvpView {

    @Inject lateinit var mPresenter: SplashMvpPresenter<SplashMvpView>

    @BindView(R.id.rlColor)
    lateinit var mRlReveal: RelativeLayout
    @BindView(R.id.imgLogo)
    lateinit var mImgLogo: ImageView
    @BindView(R.id.txtTitle)
    lateinit var mTxtTitle: AppCompatTextView

    private var mConfigSplash: ConfigSplash? = null
    private var hasAnimationStarted = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT

        activityComponent!!.inject(this)

        setUnBinder(ButterKnife.bind(this))

        mPresenter.onAttach(this@SplashActivity)

        setUp()
    }


    override fun openNextActivity() {
//        startActivity(AuthActivity.getStartIntent(this@SplashActivity))
//        finish()
    }


    override fun onDestroy() {
        mPresenter.onDetach()
        super.onDestroy()
    }

    override fun setUp() {

        mConfigSplash = ConfigSplash()
        initSplash(mConfigSplash!!)

        mImgLogo.setImageResource(mConfigSplash!!.logoSplash)
    }

    companion object {

        fun getStartIntent(context: Context): Intent {
            return Intent(context, SplashActivity::class.java)
        }
    }


    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus && !hasAnimationStarted) {
            startCircularReveal()
        }
    }


    fun startCircularReveal() {

        // get the final radius for the clipping circle
        val finalRadius = Math.max(mRlReveal.width, mRlReveal.height) + mRlReveal.height / 2
        //bottom or top
        val y = UIUtil.getRevealDirection(mRlReveal, mConfigSplash!!.revealFlagY)
        //left or right
        val x = UIUtil.getRevealDirection(mRlReveal, mConfigSplash!!.revealFlagX)

        mRlReveal.setBackgroundColor(resources.getColor(mConfigSplash!!.backgroundColor))
        val animator = ViewAnimationUtils.createCircularReveal(mRlReveal, x, y, 0f, finalRadius.toFloat())
        animator.setInterpolator(AccelerateDecelerateInterpolator())
        animator.setDuration(mConfigSplash!!.animCircularRevealDuration)
        animator.addListener(object : SupportAnimator.AnimatorListener {
            override fun onAnimationStart() {}

            override fun onAnimationCancel() {}

            override fun onAnimationRepeat() {}

            override fun onAnimationEnd() {

                startLogoAnimation()
            }
        })
        animator.start()
        hasAnimationStarted = true
    }


    fun startLogoAnimation() {
        mImgLogo.visibility = View.VISIBLE
        mImgLogo.setImageResource(mConfigSplash!!.logoSplash)

        YoYo.with(mConfigSplash!!.animLogoSplashTechnique).withListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {

            }

            override fun onAnimationEnd(animation: Animator) {
                startTextAnimation()
            }

            override fun onAnimationCancel(animation: Animator) {

            }

            override fun onAnimationRepeat(animation: Animator) {

            }
        }).duration(mConfigSplash!!.animLogoSplashDuration.toLong()).playOn(mImgLogo)
    }


    fun startTextAnimation() {

        mTxtTitle.text = mConfigSplash!!.titleSplash
        mTxtTitle.textSize = mConfigSplash!!.titleTextSize
        mTxtTitle.setTextColor(resources.getColor(mConfigSplash!!.titleTextColor))
        if (!mConfigSplash!!.titleFont.isEmpty())
            setFont(mConfigSplash!!.titleFont)

        val params = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        params.addRule(RelativeLayout.BELOW, R.id.flCentral)
        params.addRule(RelativeLayout.CENTER_HORIZONTAL)
        mTxtTitle.layoutParams = params
        mTxtTitle.visibility = View.VISIBLE

        YoYo.with(mConfigSplash!!.animTitleTechnique).withListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}

            override fun onAnimationEnd(animation: Animator) {
                animationsFinished()
            }

            override fun onAnimationCancel(animation: Animator) {

            }

            override fun onAnimationRepeat(animation: Animator) {

            }
        }).duration(mConfigSplash!!.animTitleDuration.toLong()).playOn(mTxtTitle)
    }


    fun setFont(font: String) {
        val type = Typeface.createFromAsset(assets, font)
        mTxtTitle.typeface = type
    }

    fun initSplash(configSplash: ConfigSplash) {

        /* you don't have to override every property */

        //Customize Circular Reveal
        configSplash.backgroundColor = R.color.overlayPrimary //any color you want form colors.xml
        configSplash.animCircularRevealDuration = 2000 //int ms
        configSplash.revealFlagX = Flags.REVEAL_RIGHT  //or Flags.REVEAL_LEFT
        configSplash.revealFlagY = Flags.REVEAL_BOTTOM //or Flags.REVEAL_TOP

        //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

        //Customize Logo
        configSplash.logoSplash = R.drawable.log //or any other drawable
        configSplash.animLogoSplashDuration = 2000 //int ms
        configSplash.animLogoSplashTechnique = Techniques.FadeInDown //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)


        //Customize Title
        //configSplash.setTitleSplash("SIM Registration");
        configSplash.titleSplash = ""
        configSplash.titleTextColor = R.color.white
        configSplash.titleTextSize = 30f //float value
        configSplash.animTitleDuration = 3000
        configSplash.animTitleTechnique = Techniques.FlipInX
        configSplash.titleFont = "fonts/quicksand_regular.ttf" //provide string to your font located in assets/fonts/

    }

    fun animationsFinished() {


        val auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        if(currentUser==null)
            startActivity(MainActivity.getStartIntent(this@SplashActivity))
        else
            startActivity(AuthActivity.getStartIntent(this@SplashActivity))
        finish()

    }


    override fun remove(fragment: BaseFragment) {

    }

}
