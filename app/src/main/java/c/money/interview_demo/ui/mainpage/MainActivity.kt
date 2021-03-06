package c.money.interview_demo.ui.mainpage

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import c.money.interview_demo.R
import c.money.interview_demo.base.BaseActivity
import c.money.interview_demo.base.util.NetworkUtil
import c.money.interview_demo.base.wrapper.toolbar.ToolbarWrapper
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), MainPageContract.View {

    private var toolbarWrapper: ToolbarWrapper? = null

    private var router: MainPageRouter? = null
    private var presenter: MainPagePresenter? = null

    init {
        router = MainPageRouter(this)
        presenter = MainPagePresenter(router!!)
    }

    override fun initView() {
        toolbarWrapper = ToolbarWrapper(this)
        toolbarWrapper?.setBackLayoutEnable(false)
        textRequestApi.setOnClickListener {


            if (NetworkUtil.isConnect(this)) {
                presenter?.getPlaceHolder()
            } else {
                Toast.makeText(this, "please open the internet first", Toast.LENGTH_SHORT).show()

            }
         }

    }

    override val contentViewLayout: Int get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter?.bindView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter?.unbindView()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.unbindView()
    }
}

