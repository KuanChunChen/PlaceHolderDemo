package c.money.interview_demo

import android.os.Bundle
import c.money.interview_demo.base.BaseActivity



class MainActivity : BaseActivity() {



    override fun initView() {

    }

    override val contentViewLayout: Int get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

