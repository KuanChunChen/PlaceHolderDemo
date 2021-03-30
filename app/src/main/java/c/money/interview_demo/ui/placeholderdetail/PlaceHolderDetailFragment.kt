package c.money.interview_demo.ui.placeholderdetail

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.View
import c.money.interview_demo.R
import c.money.interview_demo.base.BaseFragment
import c.money.interview_demo.base.http.HttpURLConnectionClient
import c.money.interview_demo.base.wrapper.toolbar.ToolbarWrapper
import c.money.interview_demo.ui.placeholder.BundleKey
import kotlinx.android.synthetic.main.fragment_placeholder_detail.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PlaceHolderDetailFragment : BaseFragment() {


    private var toolbarWrapper: ToolbarWrapper? = null

    companion object {

        @JvmStatic
        fun newInstance() = PlaceHolderDetailFragment()
    }

    override val contentViewLayout: Int
        get() = R.layout.fragment_placeholder_detail

    override fun initView(view: View, savedInstanceState: Bundle?) {
        toolbarWrapper = ToolbarWrapper(this)
        toolbarWrapper?.setBackLayoutEnable(true)
        toolbarWrapper?.setBackLayoutListener(object :ToolbarWrapper.IOnClick{
            override fun backLayoutOnClick() {
                activity?.supportFragmentManager?.popBackStack()

            }
        })

        arguments?.let {
            val id = it.getString(BundleKey.EXTRA_KEY_ID.name)
            val title = it.getString(BundleKey.EXTRA_KEY_TITLE.name)
            val url = it.getString(BundleKey.EXTRA_KEY_URL.name)
            val split: List<String>? = url?.split("/")
            val newUrl = "https://ipsumimage.appspot.com/" + "600" + "," + split!![split.lastIndex]

            textTitle.text = "id:$id,\n\ntitle:$title"


            CoroutineScope(Dispatchers.IO).launch {

                val result = HttpURLConnectionClient().requestBitmap(newUrl)


                withContext(Dispatchers.Main) {

                    imageContainer.background = BitmapDrawable(requireActivity().resources, result)

                }


            }
        }


    }
}