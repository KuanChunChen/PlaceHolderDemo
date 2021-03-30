package c.money.interview_demo.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener

abstract class BaseFragment : Fragment() {

    @get:LayoutRes
    abstract val contentViewLayout: Int

    protected abstract fun initView(view: View, savedInstanceState: Bundle?)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view , savedInstanceState)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(contentViewLayout, container, false)
    }


    fun setUpFragmentResultListener(initRequestKey: String) {

        parentFragmentManager.setFragmentResultListener(
            initRequestKey,
            this,
            FragmentResultListener { requestKey, result ->
                onFragmentResult(requestKey, result)
            })
    }

    fun clearFragmentResultListener(initRequestKey: String){
        parentFragmentManager.clearFragmentResult(initRequestKey)

    }

    open fun onFragmentResult(requestKey: String, result: Bundle) = let {
        Log.d(this.tag, "$requestKey,$result")
    }

}
