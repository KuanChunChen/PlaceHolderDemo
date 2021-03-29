package c.money.interview_demo.ui.placeholder

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import c.money.interview_demo.R
import c.money.interview_demo.base.BaseFragment
import c.money.interview_demo.base.wrapper.toolbar.ToolbarWrapper
import c.money.interview_demo.model.ui.PlaceHolderModel
import c.money.interview_demo.ui.mainpage.MainPagePresenter
import c.money.interview_demo.ui.mainpage.MainPageRouter
import kotlinx.android.synthetic.main.fragment_placeholder.*


class PlaceHolderFragment : BaseFragment() ,PlaceHolderContract.View{


    private var toolbarWrapper: ToolbarWrapper? = null
    private var router: PlaceHolderRouter? = null
    private var presenter: PlaceHolderPresenter? = null
    private var interactor: PlaceHolderInteractor? = null
    private var repo: PlaceHolderRepository? = null




    companion object {

        @JvmStatic
        fun newInstance() = PlaceHolderFragment()
    }

    override val contentViewLayout: Int
        get() = R.layout.fragment_placeholder


    init {
        router = PlaceHolderRouter(this)
        repo = PlaceHolderRepository()
        interactor = PlaceHolderInteractor(repo!!)
        presenter = PlaceHolderPresenter(router!!, interactor!!)
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        toolbarWrapper = ToolbarWrapper(this)
        toolbarWrapper?.setBackLayoutEnable(true)
        toolbarWrapper?.setBackLayoutListener(object :ToolbarWrapper.IOnClick{
            override fun backLayoutOnClick() {
                activity?.supportFragmentManager?.popBackStack()
            }
        })


        val layoutManager = GridLayoutManager(context, 4)
        gridListView.layoutManager = layoutManager

        val placeHolderAdapter = object :PlaceHolderAdapter(){}
        gridListView.adapter = placeHolderAdapter
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.bindView(this)
        presenter?.getDataFromServer()

    }

    override fun setRecyclerViewItem(data: PlaceHolderModel) {

    }
}