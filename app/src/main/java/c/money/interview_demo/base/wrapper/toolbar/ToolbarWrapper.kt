package c.money.interview_demo.base.wrapper.toolbar

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import c.money.interview_demo.R
import c.money.interview_demo.base.BaseActivity
import c.money.interview_demo.base.BaseFragment

class ToolbarWrapper {


    private var toolbarTitle: TextView? = null
    private var toolbarImage: ImageView? = null
    private var toolbarBack: LinearLayout? = null
    private var baseActivity: BaseActivity? = null
    private var toolbar: Toolbar? = null


    constructor(fragment: BaseFragment) {
        baseActivity = fragment.activity as BaseActivity

        val toolbar: Toolbar? = fragment.view?.findViewById(R.id.standard_toolbar)
        init(toolbar)


    }

    constructor(activity: BaseActivity) {
        baseActivity = activity
        val toolbar: Toolbar = activity.findViewById(R.id.standard_toolbar)
        init(toolbar)
    }

    /**
     * init
     * @param toolbar
     */
    private fun init(toolbar: Toolbar?) {
        this.toolbar = toolbar
        toolbarTitle = toolbar?.findViewById(R.id.standard_toolbar_title)
        toolbarImage = toolbar?.findViewById(R.id.standard_toolbar_image)
        toolbarBack = toolbar?.findViewById(R.id.standard_toolbar_back_button)
        baseActivity!!.setSupportActionBar(toolbar)
    }


    interface IOnClick{
        fun backLayoutOnClick()
    }


    fun setBackLayoutListener(onClickImpl:IOnClick): ToolbarWrapper?{

        toolbarBack?.setOnClickListener{
            onClickImpl.backLayoutOnClick()
        }
        return this
    }

    fun setImageIcon(resId: Int): ToolbarWrapper?{

        toolbarImage?.setImageResource(resId)
        return this
    }


    fun setBackLayoutEnable(enabled: Boolean): ToolbarWrapper? {

        if (enabled) {
            toolbarBack?.visibility = View.VISIBLE
        } else {
            toolbarBack?.visibility = View.GONE
        }

        return this
    }




}