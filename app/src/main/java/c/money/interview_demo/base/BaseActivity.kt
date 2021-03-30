package c.money.interview_demo.base

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import c.money.interview_demo.R

abstract class BaseActivity : AppCompatActivity() {

    @get:LayoutRes
    protected abstract val contentViewLayout: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(contentViewLayout)

        setStatusBarColor(this, isTranslate = true, isDarkText = true,
            bgColor = R.color.colorIosWhite
        )

        initView()
        supportActionBar?.hide()

    }


    protected abstract fun initView()


    /**
     * set the status bar color
     * */


    open fun setStatusBarColor(
        activity: Activity,
        isTranslate: Boolean,
        isDarkText: Boolean, @ColorRes bgColor: Int
    ) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = activity.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(
                activity,
                bgColor
            )
        }



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val decorView = window.decorView
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

    }






}