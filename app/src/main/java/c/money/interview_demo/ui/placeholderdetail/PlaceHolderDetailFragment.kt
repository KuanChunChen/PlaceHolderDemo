package c.money.interview_demo.ui.placeholderdetail

import android.os.Bundle
import android.view.View
import c.money.interview_demo.R
import c.money.interview_demo.base.BaseFragment
import c.money.interview_demo.base.wrapper.toolbar.ToolbarWrapper

class PlaceHolderDetailFragment : BaseFragment() {


    private var toolbarWrapper: ToolbarWrapper? = null

    companion object {

        @JvmStatic
        fun newInstance() = PlaceHolderDetailFragment()
    }

    override val contentViewLayout: Int
        get() = R.layout.fragment_placeholder

    override fun initView(view: View, savedInstanceState: Bundle?) {
        toolbarWrapper = ToolbarWrapper(this)
        toolbarWrapper?.setBackLayoutEnable(true)
        toolbarWrapper?.setBackLayoutListener(object :ToolbarWrapper.IOnClick{
            override fun backLayoutOnClick() {

            }
        })
    }
}