package c.money.interview_demo.ui.placeholder

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import c.money.interview_demo.R
import c.money.interview_demo.base.BaseFragment
import c.money.interview_demo.base.widget.PlaceHolderItemDecoration
import c.money.interview_demo.base.wrapper.toolbar.ToolbarWrapper
import c.money.interview_demo.model.api.GetPhotoResult
import kotlinx.android.synthetic.main.fragment_placeholder.*


class PlaceHolderFragment : BaseFragment() ,PlaceHolderContract.View{
    override fun setRecyclerViewItem() {

    }



    private var toolbarWrapper: ToolbarWrapper? = null
    private var router: PlaceHolderRouter? = null
    private var presenter: PlaceHolderPresenter? = null
    private var interactor: PlaceHolderInteractor? = null
    private var repo: PlaceHolderRepository? = null

    private var layoutManager: GridLayoutManager? = null
    private var placeHolderAdapter: PlaceHolderAdapter? = null
    private var placeHolderItemDecoration: PlaceHolderItemDecoration? = null



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


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.bindView(this)
        presenter?.getDataFromServer()

        layoutManager = GridLayoutManager(context, 4)
        placeHolderAdapter = object : PlaceHolderAdapter() {

            override fun onItemClick(id: String, title: String, thumbnailUrl: String) {
                presenter?.gotoDetailPage(id, title, thumbnailUrl)

            }
        }

        gridListView.layoutManager = layoutManager
        gridListView.adapter = placeHolderAdapter
        placeHolderItemDecoration  = PlaceHolderItemDecoration(requireContext())
        gridListView.addItemDecoration(placeHolderItemDecoration!!)



    }


    override fun setRecyclerViewItem(data: List<GetPhotoResult>) {
        placeHolderAdapter?.reset(data)
    }


    override fun showErrorMessage(msg: String) {

        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()

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